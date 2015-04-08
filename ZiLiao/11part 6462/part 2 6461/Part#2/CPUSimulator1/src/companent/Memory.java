package companent;

import basic_rules.Word;
import exception.IllegalMemoryAddressException;

public interface Memory {

	public abstract Word read(int index) throws IllegalMemoryAddressException;
	
	public abstract void write(int index,Word word) throws IllegalMemoryAddressException;
}
