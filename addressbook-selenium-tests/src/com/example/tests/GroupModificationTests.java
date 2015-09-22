package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	 
	    // actions
	    app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name = "new name";
		group.footer = "new footer";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
		
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		// compare states
		oldList.remove(0);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
	
	
}