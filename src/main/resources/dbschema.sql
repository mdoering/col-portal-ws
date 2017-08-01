DROP TABLE IF EXISTS reference;
CREATE TABLE reference (
  key serial PRIMARY KEY,
  title text,
  author text,
  year int,
  link text,
  identifier text
);

DROP TABLE IF EXISTS name;
CREATE TABLE name (
  key serial PRIMARY KEY,
  scientific_name text,
  canonical_name text,
  authorship text,
  monomial text,
  epithet text,
  infra_epithet text,
  rank int,
  notho int,
  parsed boolean,
  published_in_key int REFERENCES reference,
  published_in_year int
);
