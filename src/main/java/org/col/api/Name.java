package org.col.api;

import org.col.api.vocab.NamePart;
import org.col.api.vocab.NameType;
import org.col.api.vocab.Rank;
import org.col.api.vocab.TaxGroup;

import java.util.Objects;

/**
 *
 */
public class Name {
    private Integer key;
    private String scientificName;
    private String canonicalName;
    private String authorship;
    private String monomial;
    private String epithet;
    private String infraEpithet;
    private Rank rank;
    private NamePart notho;
    private NameType type;
    private boolean parsed;
    private Integer publishedInKey;
    private Integer publishedInYear;
    private TaxGroup group;
    private Integer originalNameKey;
    private boolean fossil;
    private boolean replacementName;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public String getAuthorship() {
        return authorship;
    }

    public void setAuthorship(String authorship) {
        this.authorship = authorship;
    }

    public String getMonomial() {
        return monomial;
    }

    public void setMonomial(String monomial) {
        this.monomial = monomial;
    }

    public String getEpithet() {
        return epithet;
    }

    public void setEpithet(String epithet) {
        this.epithet = epithet;
    }

    public String getInfraEpithet() {
        return infraEpithet;
    }

    public void setInfraEpithet(String infraEpithet) {
        this.infraEpithet = infraEpithet;
    }

    public String getRankMarker() {
        return rank == null ? null : rank.getMarker();
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public NamePart getNotho() {
        return notho;
    }

    public void setNotho(NamePart notho) {
        this.notho = notho;
    }

    public boolean isParsed() {
        return parsed;
    }

    public void setParsed(boolean parsed) {
        this.parsed = parsed;
    }

    public Integer getPublishedInKey() {
        return publishedInKey;
    }

    public void setPublishedInKey(Integer publishedInKey) {
        this.publishedInKey = publishedInKey;
    }

    public Integer getPublishedInYear() {
        return publishedInYear;
    }

    public void setPublishedInYear(Integer publishedInYear) {
        this.publishedInYear = publishedInYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return parsed == name.parsed &&
                Objects.equals(key, name.key) &&
                Objects.equals(scientificName, name.scientificName) &&
                Objects.equals(canonicalName, name.canonicalName) &&
                Objects.equals(authorship, name.authorship) &&
                Objects.equals(monomial, name.monomial) &&
                Objects.equals(epithet, name.epithet) &&
                Objects.equals(infraEpithet, name.infraEpithet) &&
                rank == name.rank &&
                notho == name.notho &&
                Objects.equals(publishedInKey, name.publishedInKey) &&
                Objects.equals(publishedInYear, name.publishedInYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, scientificName, canonicalName, authorship, monomial, epithet, infraEpithet, rank, notho, parsed, publishedInKey, publishedInYear);
    }
}
