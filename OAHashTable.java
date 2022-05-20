public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected int m;

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
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
		int first_deleted = -1;
		for (int i=0 ; i < this.table.length ; i++ ){
			hash_res = Hash(hte.GetKey(), i);

			// Checks if the key of hte already exists
			if (this.table[hash_res].GetKey() == hte.GetKey()){
				throw new KeyAlreadyExistsException(hte);
			}

			if (this.table[hash_res].GetKey() == -1){
				if (first_deleted == -1){
					first_deleted = hash_res;
				}
			}

			// Add hte if it does not exist
			if (this.table[hash_res] == null){
				// In case we can insert the element to a deleted element index
				if (first_deleted != -1){
					this.table[first_deleted] = hte;
				}
				else {
					this.table[hash_res] = hte;
				}
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
		// Finding the index of the element with key, if exists
		int index = -1;
		for (int i=0 ; i < this.table.length ; i++ ) {
			if (this.table[i].GetKey() == key){
				index = i;
				break;
			}
		}

		// In case the key is not in the table
		if (index == -1){
			throw new KeyDoesntExistException(key);
		}
		else {
			HashTableElement deleted_element = new HashTableElement(-1 , this.table[index].GetValue());
			this.table[index] = deleted_element;
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
