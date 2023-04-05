package br.dev.joaovidal.table.enums;

import br.dev.joaovidal.table.model.Book;

public enum Status {

    NOT_READ {
        @Override
        public String reviewSet(String content) {
            return "[BOOK NOT STARTED YET] " + content;
        }
    },
    READING {
        @Override
        public String reviewSet(String content) {
            return "[BOOK NOT FINISHED YET] " + content;
        }
    },
    READ {
        @Override
        public String reviewSet(String content) {
            return content;
        }
    };

    public abstract String reviewSet(String content);
}
