public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int hash_res;

		for (int i=0 ; i < this.table.length ; i++ ) {
			hash_res = Hash(key, i);

			// If we reached null, then the element does not exist in the table
			if (this.table[hash_res] == null) {
				return null;
			}

			// If we found the element, return it
			else if (this.table[hash_res].GetKey() == key) {
				return this.table[hash_res];
			}
		}

		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		int hash_res;
		boolean notfind = true;
		for (int i=0 ; i < this.table.length ; i++ ){
			hash_res = Hash(hte.GetKey(), i);

			// Checks if the key of hte already exists
			if (this.table[hash_res].GetKey() == hte.GetKey()){
				throw new KeyAlreadyExistsException(hte);
			}

			// Add hte if it does not exist
			if (this.table[hash_res] == null){
				this.table[hash_res] = hte;
				notfind = false;
				break;
			}
		}

		if (notfind){
			throw new TableIsFullException(hte);
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		HashTableElement element_key = Find(key);
		if (element_key == null){
			throw new KeyDoesntExistException(key);
		}
		else {
			// *** continue ***
			// element_key.key = -1;
		}
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
