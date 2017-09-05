package org.col.api;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import org.col.api.vocab.TaxonomicStatus;
import org.gbif.api.vocabulary.NameUsageIssue;

import java.util.Date;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public class Taxon {
  private Integer key;
  private Integer nameKey;
  private Integer parentKey;
  private Integer acceptedKey;
  private String taxonID;
  private TaxonomicStatus status;
  private String remarks;

  private Date modified;
  private Date deleted;
  private Date lastCrawled;
  private Set<NameUsageIssue> issues = EnumSet.noneOf(NameUsageIssue.class);

  public Integer getKey() {
    return key;
  }

  public void setKey(Integer key) {
    this.key = key;
  }

  public Integer getNameKey() {
    return nameKey;
  }

  public void setNameKey(Integer nameKey) {
    this.nameKey = nameKey;
  }

  public Integer getParentKey() {
    return parentKey;
  }

  public void setParentKey(Integer parentKey) {
    this.parentKey = parentKey;
  }

  public Integer getAcceptedKey() {
    return acceptedKey;
  }

  public void setAcceptedKey(Integer acceptedKey) {
    this.acceptedKey = acceptedKey;
  }

  public String getTaxonID() {
    return taxonID;
  }

  public void setTaxonID(String taxonID) {
    this.taxonID = taxonID;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public TaxonomicStatus getStatus() {
    return status;
  }

  public void setStatus(TaxonomicStatus status) {
    this.status = status;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public Date getDeleted() {
    return deleted;
  }

  public void setDeleted(Date deleted) {
    this.deleted = deleted;
  }

  public Date getLastCrawled() {
    return lastCrawled;
  }

  public void setLastCrawled(Date lastCrawled) {
    this.lastCrawled = lastCrawled;
  }

  public Set<NameUsageIssue> getIssues() {
    return issues;
  }

  public void setIssues(Set<NameUsageIssue> issues) {
    Preconditions.checkNotNull(issues, "Issues cannot be null");
    this.issues = Sets.newEnumSet(issues, NameUsageIssue.class);
  }

  public void addIssue(NameUsageIssue issue) {
    Preconditions.checkNotNull(issue, "Issue needs to be specified");
    this.issues.add(issue);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Taxon taxon = (Taxon) o;
    return Objects.equals(key, taxon.key) &&
        Objects.equals(nameKey, taxon.nameKey) &&
        Objects.equals(parentKey, taxon.parentKey) &&
        Objects.equals(acceptedKey, taxon.acceptedKey) &&
        Objects.equals(taxonID, taxon.taxonID) &&
        status == taxon.status &&
        Objects.equals(remarks, taxon.remarks) &&
        Objects.equals(modified, taxon.modified) &&
        Objects.equals(deleted, taxon.deleted) &&
        Objects.equals(lastCrawled, taxon.lastCrawled) &&
        Objects.equals(issues, taxon.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, nameKey, parentKey, acceptedKey, taxonID, status, remarks, modified, deleted, lastCrawled, issues);
  }
}
