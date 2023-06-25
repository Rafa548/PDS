
public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	public java.util.Iterator<T> iterator() {
		return (this).new VectorIterator<T>();
	}

	public java.util.ListIterator<T> listIterator() {
		return this.listIterator(0);

	}

	public java.util.ListIterator<T> listIterator(int index) {
		return (this).new VectorListIterator<T>(index);

	}

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	private class VectorIterator<K> implements java.util.Iterator<K>{
		private int current = 0;
	   
		VectorIterator() {
			current = 0;
		}
	
		public boolean hasNext() {
			return (current<nElem);
		}

		public K next() {
			if (hasNext()) 
				return (K) VectorGeneric.this.vec[current++];
			throw new IndexOutOfBoundsException("only " + nElem + " elements");
		}

		public void remove () {
			throw new UnsupportedOperationException("Operação não suportada!");
		}
	}

	private class VectorListIterator<K> implements java.util.ListIterator<K>{
		private int current = 0;
	   
		VectorListIterator(int index) {
			current = index;
		}
	
		public boolean hasNext() {
			return (current<nElem);
		}

		public K next() {
			if (hasNext()) 
				return (K) VectorGeneric.this.vec[current++];
			throw new IndexOutOfBoundsException("only " + nElem + " elements");
		}

		public void remove () {
			throw new UnsupportedOperationException("Operação não suportada!");
		}

		@Override
		public void add(K arg0) {
			throw new UnsupportedOperationException("Operação não suportada!");
			
		}

		@Override
		public boolean hasPrevious() {
			return (current>0);
		}

		@Override
		public int nextIndex() {
			return current+1;
		}

		@Override
		public K previous() {
			if (hasPrevious()) 
				return (K) VectorGeneric.this.vec[current--];
			throw new IndexOutOfBoundsException("only " + nElem + " elements");
		}

		@Override
		public int previousIndex() {
			return current-1;
		}

		@Override
		public void set(K arg0) {
			current = (int) arg0;
		}
		
	}
	
}


