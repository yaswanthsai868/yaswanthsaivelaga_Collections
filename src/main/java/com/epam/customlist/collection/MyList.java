package com.epam.customlist.collection;
import java.util.Arrays;
public class MyList<E> {
	private int size=0;
	private static final int DEFAULT_SIZE=10;
	private Object container[];
	public MyList()
	{
		this.container=new Object[DEFAULT_SIZE];
	}
	public void add(E value)
	{
		if(this.size==this.container.length)
		{
			increaseCapacity();
		}
		this.container[size++]=value;
	}
	@SuppressWarnings("unchecked")
	public void set(Integer index,E value)
	{
		if(this.size<index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			if(this.size==index)
			{
				increaseCapacity();
				this.container[size++]=value;
			}
			else
			{
				E valueToBePlaced=value;
				for(Integer traverse=index;traverse<size;traverse++)
				{
					E temp=(E)this.container[traverse];
					this.container[traverse]=valueToBePlaced;
					valueToBePlaced=temp;
				}
				this.add(valueToBePlaced);	
			}
		}
	}
	@SuppressWarnings("unchecked")
	public E get(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return (E)this.container[index];
		}
	}
	@SuppressWarnings("unchecked")
	public E remove(Integer index)
	{
		if(this.size<=index || index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			E valueToBeReturned=(E)this.container[index];
			for(Integer traverse=index;traverse<this.size-1;traverse++)
			{
				this.container[traverse]=this.container[traverse+1];
			}				
			this.size--;
			return valueToBeReturned;
		}
	}
	private void increaseCapacity()
	{
		Integer newSize=this.container.length;
		this.container=Arrays.copyOf(this.container, newSize);
	}
	public String toString()
	{
		String s="[";
		for(Integer traverse=0;traverse<this.size;traverse++)
		{
			s=s+this.container[traverse].toString();
			if(traverse!=this.size-1)
				s+=",";
		}
		s=s+"]";
		return s;
	}
}
