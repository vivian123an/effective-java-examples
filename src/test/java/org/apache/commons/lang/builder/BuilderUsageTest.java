package org.apache.commons.lang.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import com.google.common.collect.Lists;

public class BuilderUsageTest {

	@Test
	public void builderTest(){
		Staff staff1 = new Staff(123, "John Smith", new Date(2015,8,8));
        Staff staff2 = new Staff(456, "Jane Smith", new Date(2014,9,9));
        Staff staff3 = new Staff(456, "Ane Smith", new Date(2013,9,9));
       
        System.out.println("staff1's info: " + staff1);
        System.out.println("staff2's info: " + staff2);
        System.out.println("staff1's hash code: " + staff1.hashCode());
        System.out.println("staff2's hash code: " + staff2.hashCode());
        System.out.println("staff1 equals staff2? " + staff1.equals(staff2));
        
        ArrayList<Staff> list = Lists.newArrayList(staff1,staff2,staff3);
        Collections.sort(list);
        System.out.println(list);
	}
}
class Staff implements Comparable {
	 
    private long staffId;
    private String staffName;
    private Date dateJoined;
 
    public Staff() {
    }
 
    public Staff(long staffId, String staffName, Date dateJoined) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.dateJoined = dateJoined;
    }
 
    @Override
    public int compareTo(Object o) {
        int res = -1;
        if (o != null && Staff.class.isAssignableFrom(o.getClass())) {
            Staff s = (Staff) o;
            res = new CompareToBuilder().append(staffId, s.getStaffId())
            	.append(staffName, s.getStaffName()).toComparison();
        }
        return res;
    }
 
    @Override
    public boolean equals(Object o) {
        boolean res = false;
        if (o != null && Staff.class.isAssignableFrom(o.getClass())) {
            Staff s = (Staff) o;
            res = new EqualsBuilder().append(staffId, s.getStaffId()).isEquals();
        }
        return res;
    }
 
    @Override
    public int hashCode() {
        return new HashCodeBuilder(11, 23).append(staffId).toHashCode();
    }
 
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("staffId", staffId)
                .append("staffName", staffName)
                .append("dateJoined", dateJoined)
                .toString();
    }
 
    public Date getDateJoined() {
        return dateJoined;
    }
 
    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
 
    public long getStaffId() {
        return staffId;
    }
 
    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }
 
    public String getStaffName() {
        return staffName;
    }
 
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}