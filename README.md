
Transaction

```
curl --location --request POST 'localhost:8080/transaction' \
--header 'Content-Type: application/json' \
--data-raw '{
    "datetime": "2019-10-05T14:48:01+01:00",
    "amount": 1.1
}'
```

Get Transactions History

```
curl --location --request POST 'localhost:8080/get-transactions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "startDatetime": "2019-10-05T10:48:01+00:00",
    "endDatetime": "2019-10-05T23:48:02+00:00"
 }'
```