package org.col.tasks.importer.neo.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.UUID;

public class UUIDSerializer extends Serializer<UUID> {

    @Override
    public void write(final Kryo kryo, final Output output, final UUID uuid) {
        output.writeLong(uuid.getMostSignificantBits(), false);
        output.writeLong(uuid.getLeastSignificantBits(), false);
    }

    @Override
    public UUID read(final Kryo kryo, final Input input, final Class<UUID> uuidClass) {
        return new UUID(input.readLong(false), input.readLong(false));
    }
}