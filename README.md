# AQPHashTable, DoubleHashTable, LPHashTable, QPHashTable Implementation README

These Java classes represent different types of open addressing hash tables with various collision resolution strategies. Each class extends the abstract class `OAHashTable` and implements the `IHashTable` interface.
The project is part of "Data Structures" course.

## AQPHashTable

### Description
The `AQPHashTable` class represents a hash table that uses Quadratic Probing as its collision resolution strategy. It overrides the `Hash` method to implement the specific quadratic probing formula.

### Constructor
- `AQPHashTable(int m, long p)`: Initializes the AQPHashTable with the given size `m` and prime number `p`. It also initializes the hash function using the `ModHash` class.

## DoubleHashTable

### Description
The `DoubleHashTable` class represents a hash table that uses Double Hashing as its collision resolution strategy. It overrides the `Hash` method to implement the specific double hashing formula.

### Constructor
- `DoubleHashTable(int m, long p)`: Initializes the DoubleHashTable with the given size `m` and prime number `p`. It also initializes two hash functions using the `ModHash` class.

## LPHashTable

### Description
The `LPHashTable` class represents a hash table that uses Linear Probing as its collision resolution strategy. It overrides the `Hash` method to implement the specific linear probing formula.

### Constructor
- `LPHashTable(int m, long p)`: Initializes the LPHashTable with the given size `m` and prime number `p`. It also initializes the hash function using the `ModHash` class.

## QPHashTable

### Description
The `QPHashTable` class represents a hash table that uses Quadratic Probing as its collision resolution strategy. It overrides the `Hash` method to implement the specific quadratic probing formula.

### Constructor
- `QPHashTable(int m, long p)`: Initializes the QPHashTable with the given size `m` and prime number `p`. It also initializes the hash function using the `ModHash` class.

## HashTableElement

### Description
The `HashTableElement` class represents an element in the hash table, consisting of a key and a value.

### Constructor
- `HashTableElement(long key, long value)`: Initializes a HashTableElement with the given key and value.

## IHashTable

### Description
The `IHashTable` interface defines the basic operations that a hash table should support. It includes methods for inserting, deleting, and finding elements, along with exceptions for specific scenarios.

### Methods
- `Insert(HashTableElement hte)`: Inserts a HashTableElement into the hash table.
- `Delete(long key)`: Deletes an element with the specified key from the hash table.
- `Find(long key)`: Finds and returns a HashTableElement with the specified key.

### Exceptions
- `TableIsFullException`: Thrown when the hash table is full during insertion.
- `KeyAlreadyExistsException`: Thrown when trying to insert an element with a key that already exists.
- `KeyDoesntExistException`: Thrown when trying to delete or find an element with a key that doesn't exist.

## ModHash

### Description
The `ModHash` class represents a universal hash function used by the hash tables. It includes a method to generate a random hash function based on the provided parameters.

### Constructor
- `ModHash(long a, long b, long p, int m)`: Initializes a ModHash object with the given parameters.

### Methods
- `GetFunc(int m, long p)`: Generates and returns a random ModHash function.

## MyTest

### Description
The `MyTest` class provides a main method for testing the different hash table implementations. It creates instances of each hash table, performs various operations, and measures the time taken for each operation.

### Methods
- `LP(HashTableElement[] arr)`: Tests the LPHashTable implementation.
- `AQP(HashTableElement[] arr)`: Tests the AQPHashTable implementation.
- `QP(HashTableElement[] arr)`: Tests the QPHashTable implementation.
- `Double(HashTableElement[] arr)`: Tests the DoubleHashTable implementation.

Feel free to use and modify these classes for your specific needs.
