package com.programyourhome.huebridgesimulator.model.connection;

import java.util.ArrayList;

import com.programyourhome.huebridgesimulator.model.connection.ErrorMessage.Wrapper;

/**
 * JSON DTO for a hue bridge error message, according to the spec from the Philips website.
 * The ArrayList<Wrapper> construct is needed to create the right type of JSON output, namely an array with one item.
 */
public class ErrorMessage extends ArrayList<Wrapper> implements HueBridgeResponse {

    private static final long serialVersionUID = 1L;

    public ErrorMessage(final ErrorType type, final String address, final String description) {
        this.add(new Wrapper(type, address, description));
    }

    public class Wrapper {

        private final Error error;

        public Wrapper(final ErrorType type, final String address, final String description) {
            this.error = new Error();
            this.error.type = type.getCode();
            this.error.address = address;
            this.error.description = description;
        }

        public Error getError() {
            return this.error;
        }

        @Override
        public String toString() {
            return this.error.toString();
        }

        public class Error {
            private int type;
            private String address;
            private String description;

            public int getType() {
                return this.type;
            }

            public String getAddress() {
                return this.address;
            }

            public String getDescription() {
                return this.description;
            }

            @Override
            public String toString() {
                return "type: " + this.type + ", address: " + this.address + ", description: " + this.description;
            }
        }

    }

}
