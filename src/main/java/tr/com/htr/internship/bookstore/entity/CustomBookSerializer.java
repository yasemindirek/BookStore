package tr.com.htr.internship.bookstore.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class CustomBookSerializer extends StdSerializer<Book> {

    protected CustomBookSerializer(Class<Book> t) {
        super(t);
    }

    @Override
    public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        serializerProvider.defaultSerializeField("id", book.getId(), jsonGenerator);
        serializerProvider.defaultSerializeField("bookName", book.getBookName(), jsonGenerator);
        serializerProvider.defaultSerializeField("author", book.getAuthor().getId(), jsonGenerator);
        jsonGenerator.writeEndObject();
    }
}

