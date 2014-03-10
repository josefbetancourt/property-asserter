/**
 * 
 */
package com.octodecillion.test;

import static com.octodecillion.test.PropertyAsserter.assertBasicGetterSetterBehavior;
import static com.octodecillion.test.PropertyAsserter.assertBasicGetterSetterBehaviorWithBlacklist;
import mockit.Expectations;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Assert;
import org.junit.Test;


/**
 * Test {@link PropertyAsserter}.
 * <p>
 * 
 * @author jbetancourt
 *
 */
public class PropertyAsserterTest {
	
	/**
	 * Test method for {@link PropertyAsserter#assertBasicGetterSetterBehavior(Object)}
	 */
	@Test
	public final void shouldAssertBasicGetterSetterBehaviorObject() {
		assertBasicGetterSetterBehavior(new Target1());
	}

	/**
	 * Test method for {@link com.octodecillion.test.PropertyAsserter#assertGetterSetterBlacklist(java.lang.Object, java.lang.String[])}.
	 */
	@Test
	public void shouldSkipPropInBlackList(@Mocked final Target1 target) {		
		new Expectations() {{
			new Target1();
			target.getData(); times=0;			
		}};
		
		assertBasicGetterSetterBehaviorWithBlacklist(new Target1(), "data");
	}

	/**
	 * Test method for {@link com.octodecillion.test.PropertyAsserter#assertGetterSetterBlacklist(java.lang.Object, java.lang.String[])}.
	 * <p>
	 * Should invoke getter/setter methods once.

	 */
	@Test(expected=AssertionError.class)
	public void shouldTestPropertyNotFoundInBlackList(@Mocked final Target1 target) {		
		new NonStrictExpectations() {{
			target.setData((String) any); times=1;
			target.getData(); times=1;
		}};
		
		assertBasicGetterSetterBehaviorWithBlacklist(target,new String[]{"xxx"});
	}

	/**
	 * Test method for {@link com.octodecillion.test.PropertyAsserter#assertGetterSetterBlacklist(java.lang.Object, java.lang.String[])}.
	 */
	@Test
	public void testAssertBasicGetterSetterBehavior() {
		
		new MockUp<Target1>() {			
			// FindBugs marks this as uncallable method. Should be ignored.
			@Mock
			public void setData(Invocation invocation, String prop) {
				Target1 obj = (Target1)invocation.getInvokedInstance();
				if(obj != null){
					obj.setData(prop);
					setPass(true);	  
				}
		    }
		};
		
		setPass(false);		
		assertBasicGetterSetterBehavior(new Target1());		
		assertPass("Did not invoke setter for: 'data'");
	}	

	// hack to allow use of assertions in Stateful JMockit mocks.
	private boolean pass = false;	

	/**
	 * 
	 * @param pass
	 */
	private void setPass(boolean pass){
		this.pass = pass;
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean getPass(){
		return this.pass;
	}
	
	/**
	 * 
	 * @param msg
	 */
	private void assertPass(String msg){
		Assert.assertTrue(msg, pass);
	}
	
}
