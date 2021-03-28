#Request A GET
response = requests.get(httplocalhost8080jpa-products1)
request_1 = response.json()
print User A get, request_1

#Request B GET
response = requests.get(httplocalhost8080jpa-products1)
request_2 = response.json()
print User B get, request_2

#Request B Update
request_2[name] = New awsome TV
response = requests.put(httplocalhost8080jpa-products, json = request_2)
print User B save, response.json()

#Request A Update (Blows up on a lock exception)
request_1[name] = Newer awesomer flatscreen TV
response = requests.put(httplocalhost8080jpa-products, json = request_1)
print User A save, response.json()