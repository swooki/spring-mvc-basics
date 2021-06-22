package com.kwonees.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="suppliers")
public class Supplier {
	@Id
	@Column(name="supplier_id")
	private Integer supplierId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="contact_title")
	private String contactTitle;
	private String address;
	private String city;
	private String region;
	@Column(name="postal_code")
	private String postalCode;
	private String country;
	private String phone;
	private String fax;
	@Column(name="home_page")
	private String homePage;
}
