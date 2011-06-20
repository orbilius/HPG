package se.orbilius.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import se.orbilius.shared.HousePriceInfo;

public class ChainImpl implements Chain {

	
	private List<Command> commandList = new ArrayList<Command>();
	private List<String> errorMessages = new ArrayList<String>();
	
	
	@Override
	public String getErrorMessage() {
		String s = "Errors in chain: ";
		for (String message : errorMessages) {
			s = s + message;
		}
		return s;
	}

	@Override
	public void addCommand(Command cmd) {
		commandList.add(cmd);
	}


	@Override
    public boolean execute(HousePriceInfo info)
    {
        Iterator<Command> it = commandList.iterator();

        while (it.hasNext())
        {
        	Command cmd = it.next();
            if (!cmd.execute(info))
            {
            	errorMessages.add(cmd.getErrorMessage());
                return false;
            }
        }

        return true;
    }



}
