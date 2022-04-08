CREATE TABLE "contacts" (
    "ContactId" INT PRIMARY KEY NOT NULL,
    "Name" VARCHAR NOT NULL,
    "Email" VARCHAR NOT NULL,
    "PhoneNumber" VARCHAR NOT NULL
);

CREATE TABLE "ListName" (
    "ListNameId" INT NOT NULL,
    "NAME" VARCHAR NOT NULL,
    "ContactId" INT NOT NULL,
    CONSTRAINT "PK_ListName" PRIMARY KEY ("ListNameId"),
    CONSTRAINT "FK_ContactId" FOREIGN KEY ("ContactId") REFERENCES "contacts" ("ContactId") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX "IFK_ContactId" ON "ListName" ("ContactId");

INSERT INTO "contacts" VALUES (1, 'Mateso Musiwa', 'mamusiwa@revature.net', '456-678-0389');
INSERT INTO "contacts" VALUES (2, 'Maryan Noor', 'manoor@revature.net', '789-678-0334');
INSERT INTO "contacts" VALUES (3, 'Maella Fodop', 'mafodop@revature.net', '456-243-9473');
INSERT INTO "contacts" VALUES (4, 'Grace Niyo', 'grniyo@revature.net', '456-245-9893');
INSERT INTO "contacts" VALUES (5, 'Courtney Pearson', 'copearson@revature.net', '610-243-9467');
INSERT INTO "contacts" VALUES (6, 'Laura', 'laura@revature.net', '893-816-9454');
INSERT INTO "contacts" VALUES (3, 'Dana', 'dana@revature.net', '901-243-7733');
