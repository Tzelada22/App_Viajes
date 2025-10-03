package com.example.app;

public final class ViajeContract {
    private ViajeContract() {}

    public static class UsuarioEntry {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_USER_ID = "_id";
        public static final String COLUMN_USER_EMAIL = "email";
        public static final String COLUMN_USER_PASSWORD = "CLAVE";
        public static final String COLUMN_USER_NAME = "nombre";
    }

    public static class NotaEntry {
        public static final String TABLE_NAME = "notas";
        public static final String COLUMN_NOTA_ID = "_id";
        public static final String COLUMN_NOTA_AUTHOR = "nombre_viajero";
        public static final String COLUMN_NOTA_PLACE = "lugar_visitado";
        public static final String COLUMN_NOTA_CONTENT = "descripcion";
        public static final String COLUMN_NOTA_DATE = "fecha";
    }
}