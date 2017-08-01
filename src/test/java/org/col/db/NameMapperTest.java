package org.col.db;

import com.google.common.base.Stopwatch;
import org.col.api.Name;
import org.col.api.vocab.Rank;
import org.col.db.mapper.NameMapper;
import org.junit.Test;

/**
 *
 */
public class NameMapperTest extends MapperTestBase<NameMapper> {

    private int repeat = 10000;

    public NameMapperTest() {
        super(NameMapper.class);
    }

    private void insert() throws Exception {
        Name n = new Name();
        n.setScientificName("Abies alba Mill.");
        n.setCanonicalName("Abies alba");
        n.setAuthorship("Mill.");
        n.setMonomial("Abies");
        n.setEpithet("alba");
        n.setInfraEpithet(null);
        n.setRank(Rank.SPECIES);

        for (int i = 0; i < repeat; i++) {
            mapper.insert(n);
        }
        commit();
    }

    private void read() throws Exception {
        for (int i = 2; i < repeat+2; i++) {
            //int key = 2 + rnd.nextInt(inserts);
            Name n = mapper.get(i);
        }

    }

    @Test
    public void performance() throws Exception {
        Stopwatch watch = Stopwatch.createStarted();

        insert();
        watch.stop();
        System.out.println(repeat + " INSERTS: " + watch.toString());

        watch.reset();
        watch.start();
        read();
        watch.stop();
        System.out.println(repeat+ " READS: " + watch.toString());
    }

}