
INSERT INTO users (id, name)
VALUES
    (1, 'Lady Gaga'),
    (2, 'Taylor Swift'),
    (3, 'Billie Eilish');

INSERT INTO contracts (id, number, category, company, yearly_premium, user_id)
VALUES
    (1, 'ALL-1001-L', 'LIABILITY', 'Allianz', 100.99, 1),
    (2, 'ALL-1002-H', 'HOUSEHOLD', 'Allianz', 200.50, 1),
    (3, 'ERG-1003-H', 'HOUSEHOLD', 'ERGO', 25.75, 1);

INSERT INTO contracts (id, number, category, company, yearly_premium, user_id)
VALUES
    (4, 'AXA-2004-L', 'LIABILITY', 'AXA', 12.90, 2),
    (5, 'AXA-2005-L', 'LIABILITY', 'AXA', 35.0, 2),
    (6, 'AXA-2006-H', 'HOUSEHOLD', 'AXA', 50.0, 2);

INSERT INTO contracts (id, number, category, company, yearly_premium, user_id)
VALUES
    (7, 'ALL-3007-L', 'LIABILITY', 'Allianz', 18.0, 3),
    (8, 'AXA-3008-L', 'LIABILITY', 'AXA', 28.0, 3),
    (9, 'ARA-3009-L', 'LIABILITY', 'ARAG', 48.87, 3);
