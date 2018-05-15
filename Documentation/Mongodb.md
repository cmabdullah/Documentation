> ➜  ~ mongod

> ➜  ~ mongo

#### Create Databases

> use mydb

	> use mydb
	switched to db mydb
	> show dbs
	admin   0.000GB
	config  0.000GB
	local   0.000GB

#### Insert value into databases

> db.movie.insert({"name":"C M Abdullah Khan"})

	> db.movie.insert({"name":"C M Abdullah Khan"})
	WriteResult({ "nInserted" : 1 })
	> show dbs
	admin   0.000GB
	config  0.000GB
	local   0.000GB
	mydb    0.000GB
	>

#### Drop databases

> db.dropDatabase()

	> db.dropDatabase()
	{ "dropped" : "mydb", "ok" : 1 }
	>

# The createCollection() Method

#### MongoDB db.createCollection(name, options) is used to create collection.

	> use test
	switched to db test
	> db.createCollection("mycollection")
	{ "ok" : 1 }
	> show collections
	mycollection
	>

