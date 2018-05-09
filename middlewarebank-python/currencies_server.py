import json
import time
import random

import grpc
from concurrent import futures

from generated import currencies_pb2, currencies_pb2_grpc

global_data = []


class CurrenciesStreamServer(currencies_pb2_grpc.CurrenciesStreamServicer):
    def __init__(self):
        pass

    def GetCurrenciesRate(self, request, context):
        while True:
            for currency in request.currencies:
                for curr in global_data:
                    if curr['code'] == currencies_pb2.Currency.Name(currency):
                        yield currencies_pb2.ExchangeRate(currency=currency,
                                                          rate=(random.uniform(0.8, 1) * curr['mid']))
                time.sleep(10)
            time.sleep(random.randint(1, 10))


def serve():
    json_data = open("currencies.json").read()
    data = json.loads(json_data)
    for obj in data['rates']:
        global_data.append(obj)
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    currencies_pb2_grpc.add_CurrenciesStreamServicer_to_server(
        CurrenciesStreamServer(), server)
    server.add_insecure_port('localhost:50051')
    server.start()
    try:
        while True:
            time.sleep(60 * 60 * 24)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
