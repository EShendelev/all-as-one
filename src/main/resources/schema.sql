CREATE TABLE IF NOT EXISTS users (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(250) NOT NULL
    games_count INTEGER DEFAULT 0,
    winrate NUMERIC DEFAULT 0.0
)