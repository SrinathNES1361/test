package com.ebsco.JsonToXml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({ "pubmed" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "meta")
public class CollectionDetails {
	@JacksonXmlProperty(localName = "ti")
	private String citation_title;
	@JacksonXmlProperty(localName = "au")
	private String citation_authors;
	@JacksonXmlProperty(localName = "ia")
	private String collab_author;
	@JsonIgnore
	private String citation_date;
	@JacksonXmlProperty(localName = "yy")
	private String year;
	@JacksonXmlProperty(localName = "mm")
	private String month;
	@JacksonXmlProperty(localName = "dd")
	private String day;
	@JacksonXmlProperty(localName = "abjr")
	private String citation_publisher;
	@JacksonXmlProperty(localName = "jr")
	private String citation_journal_title;
	@JacksonXmlProperty(localName = "pubmed")
	private String citation_pmid;
	@JacksonXmlProperty(localName = "url")
	private String citation_abstract_html_url;
	@JacksonXmlProperty(localName = "vo")
	private String citation_volume;
	@JacksonXmlProperty(localName = "is")
	private String citation_issue;
	@JacksonXmlProperty(localName = "pg")
	private String pagination;
	@JacksonXmlProperty(localName = "sp")
	private String start_page;
	@JacksonXmlProperty(localName = "ep")
	private String end_page;
	@JacksonXmlProperty(localName = "zd")
	private String citation_doi;
	@JacksonXmlProperty(localName = "sn")
	private String citation_issn;
	@JsonIgnore
	private String canonical;
	@JsonIgnore
	private String cit;

	public CollectionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionDetails(String citation_title, String citation_authors, String collab_author, String citation_date,
			String year, String month, String day, String citation_publisher, String citation_journal_title,
			String citation_pmid, String citation_abstract_html_url, String citation_volume, String citation_issue,
			String pagination, String start_page, String end_page, String citation_doi, String citation_issn,
			String canonical, String cit) {
		super();
		this.citation_title = citation_title;
		this.citation_authors = citation_authors;
		this.collab_author = collab_author;
		this.citation_date = citation_date;
		this.year = year;
		this.month = month;
		this.day = day;
		this.citation_publisher = citation_publisher;
		this.citation_journal_title = citation_journal_title;
		this.citation_pmid = citation_pmid;
		this.citation_abstract_html_url = citation_abstract_html_url;
		this.citation_volume = citation_volume;
		this.citation_issue = citation_issue;
		this.pagination = pagination;
		this.start_page = start_page;
		this.end_page = end_page;
		this.citation_doi = citation_doi;
		this.citation_issn = citation_issn;
		this.canonical = canonical;
		this.cit = cit;
	}

	public String getCitation_title() {
		return citation_title;
	}

	public void setCitation_title(String citation_title) {
		this.citation_title = citation_title;
	}

	public String getCitation_authors() {
		if(citation_authors != null) {
			if(citation_authors.equalsIgnoreCase(";")) {
				return null;
			}
			return citation_authors;
		}
		return citation_authors;
	}

	public void setCitation_authors(String citation_authors) {
		this.citation_authors = citation_authors;
	}

	public String getCollab_author() {
		if(collab_author != null) {
			if(collab_author.equalsIgnoreCase(";")) {
				return null;
			}
			return collab_author;
		}
		return collab_author;
	}

	public void setCollab_author(String collab_author) {
		this.collab_author = collab_author;
	}

	public String getCitation_date() {
		return citation_date;
	}

	public void setCitation_date(String citation_date) {
		this.citation_date = citation_date;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCitation_publisher() {
		return citation_publisher;
	}

	public void setCitation_publisher(String citation_publisher) {
		this.citation_publisher = citation_publisher;
	}

	public String getCitation_journal_title() {
		return citation_journal_title;
	}

	public void setCitation_journal_title(String citation_journal_title) {
		this.citation_journal_title = citation_journal_title;
	}

	public String getCitation_pmid() {
		return citation_pmid;
	}

	public void setCitation_pmid(String citation_pmid) {
		this.citation_pmid = citation_pmid;
	}

	public String getCitation_abstract_html_url() {
		return citation_abstract_html_url;
	}

	public void setCitation_abstract_html_url(String citation_abstract_html_url) {
		this.citation_abstract_html_url = citation_abstract_html_url;
	}

	public String getCitation_volume() {
		return citation_volume;
	}

	public void setCitation_volume(String citation_volume) {
		this.citation_volume = citation_volume;
	}

	public String getCitation_issue() {
		return citation_issue;
	}

	public void setCitation_issue(String citation_issue) {
		this.citation_issue = citation_issue;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public String getStart_page() {
		return start_page;
	}

	public void setStart_page(String start_page) {
		this.start_page = start_page;
	}

	public String getEnd_page() {
		return end_page;
	}

	public void setEnd_page(String end_page) {
		this.end_page = end_page;
	}

	public String getCitation_doi() {
		return citation_doi;
	}

	public void setCitation_doi(String citation_doi) {
		this.citation_doi = citation_doi;
	}

	public String getCitation_issn() {
		return citation_issn;
	}

	public void setCitation_issn(String citation_issn) {
		this.citation_issn = citation_issn;
	}

	public String getCanonical() {
		return canonical;
	}

	public void setCanonical(String canonical) {
		this.canonical = canonical;
	}

	public String getCit() {
		return cit;
	}

	public void setCit(String cit) {
		this.cit = cit;
	}
}
