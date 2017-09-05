package org.col.parser;

import org.col.api.Name;
import org.col.api.vocab.NamePart;
import org.col.api.vocab.Rank;
import org.gbif.api.model.checklistbank.ParsedName;
import org.gbif.nameparser.GBIFNameParser;

import java.util.Optional;

/**
 * Wrapper around the GBIF Name parser to deal with clearing house Name class.
 */
public class NameParser {
    private static final GBIFNameParser PARSER = new GBIFNameParser();

    public Name parse(String name, Optional<Rank> rank) {
        ParsedName pn = PARSER.parseQuietly(name, toGbifRank(rank));
        Name n = new Name();
        n.setScientificName(name);
        n.setCanonicalName(pn.canonicalName());
        n.setAuthorship(pn.authorshipComplete());
        n.setMonomial(pn.getGenusOrAbove());
        n.setEpithet(pn.getSpecificEpithet());
        n.setInfraEpithet(pn.getInfraSpecificEpithet());
        n.setNotho(toPart(pn.getNotho()));
        n.setParsed(pn.isParsed());
        n.setPublishedInYear(pn.getYearInt());
        rank.ifPresent(n::setRank);
        return n;
    }

    private static org.gbif.api.vocabulary.Rank toGbifRank(Optional<Rank> rank) {
        return rank.map(r -> org.gbif.api.vocabulary.Rank.valueOf(r.name())).orElse(null);
    }

    private static NamePart toPart(org.gbif.api.vocabulary.NamePart part) {
        return part == null ? null : NamePart.valueOf(part.name());
    }
}
