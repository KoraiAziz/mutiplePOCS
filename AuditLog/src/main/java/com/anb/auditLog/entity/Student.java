package com.anb.auditLog.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.anb.auditLog.model.AuditBase;

@Entity
@Table(name="student")
@Audited
public class Student extends AuditBase<String> implements Serializable {
	

		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "identityNumber")
	    private Long identityNumber;
	    
	    @Column(name = "mobileNumber")
	    private Long mobileNumber;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "dept")
	    private String departmant;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getIdentityNumber() {
			return identityNumber;
		}

		public void setIdentityNumber(Long identityNumber) {
			this.identityNumber = identityNumber;
		}

		public Long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDepartmant() {
			return departmant;
		}

		public void setDepartmant(String departmant) {
			this.departmant = departmant;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", identityNumber=" + identityNumber + ", mobileNumber="
					+ mobileNumber + ", email=" + email + ", departmant=" + departmant + "]";
		}

	    

	    
	    
	

}
