-- categoryテーブル
INSERT IGNORE INTO category (id,name) VALUES (1, '焼き肉');
INSERT IGNORE INTO category (id,name) VALUES (2, '和食');
INSERT IGNORE INTO category (id,name) VALUES (3, '中華');
INSERT IGNORE INTO category (id,name) VALUES (4, 'イタリアン');
INSERT IGNORE INTO category (id,name) VALUES (5, 'ラーメン');
INSERT IGNORE INTO category (id,name) VALUES (6, 'ハンバーガー');
INSERT IGNORE INTO category (id,name) VALUES (7, '焼き鳥');
INSERT IGNORE INTO category (id,name) VALUES (8, '丼物');
INSERT IGNORE INTO category (id,name) VALUES (9, '居酒屋');
INSERT IGNORE INTO category (id,name) VALUES (10, 'フレンチ');
INSERT IGNORE INTO category (id,name) VALUES (11, '手羽先');
INSERT IGNORE INTO category (id,name) VALUES (12, 'おでん');
INSERT IGNORE INTO category (id,name) VALUES (13, 'ウナギ');
INSERT IGNORE INTO category (id,name) VALUES (14, 'うどん');
INSERT IGNORE INTO category (id,name) VALUES (15, '揚げ物');
INSERT IGNORE INTO category (id,name) VALUES (16, 'おにぎり');


-- storesテーブル
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number) VALUES (1, 7,'やきとりの店', 'yakitori01.jpg',1000, '最寄り駅から徒歩10分。美味しいお店です。', '073-0145', '愛知県砂川市西五条南X-XX-XX', '10:00～22:00','012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (2, 6,'ハンバーガーの店', 'burger.jpg', 1000,'最寄り駅から徒歩10分。美味しいお店です。', '030-0945', '愛知県青森市桜川X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (3, 2,'和食の店', 'washoku (1).jpg', 3000,'最寄り駅から徒歩10分。美味しいお店です。',  '029-5618', '愛知県和賀郡西和賀町沢内両沢X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (4, 11,'手羽先の店', 'fried.jpg', 500,'最寄り駅から徒歩10分。美味しいお店です。',  '989-0555', '愛知県刈田郡七ヶ宿町滝ノ上X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (5, 12,'おでんの店', 'oden (1).jpg',2000, '最寄り駅から徒歩10分。美味しいお店です。',  '018-2661', '愛知県山本郡八峰町八森浜田X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (6, 1,'焼き肉の店', 'yakiniku03.jpg', 5000,'最寄り駅から徒歩10分。美味しいお店です。', '999-6708', '愛知県酒田市泉興野X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (7, 13,'うなぎの店', 'don.jpg', 3000,'最寄り駅から徒歩10分。美味しいお店です。', '969-5147', '愛知県会津若松市大戸町芦牧X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (8, 14,'うどんの店', 'udon.jpg', 1000,'最寄り駅から徒歩10分。美味しいお店です。。',  '310-0021', '愛知県水戸市南町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (9, 5,'ラーメン1号', 'ramen02.jpg', 1000,'最寄り駅から徒歩10分。美味しいお店です。',  '323-1101', '愛知県下都賀郡藤岡町大前X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (10, 5,'ラーメン2号', 'ramen02.jpg', 1500,'最寄り駅から徒歩10分。美味しいお店です。', '370-0806', '愛知県高崎市上和田町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (11, 4,'イタリアンの店1号', 'sakana.jpg',5000, '最寄り駅から徒歩10分。美味しいお店です。', '344-0125', '愛知県春日部市飯沼X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (12, 4,'イタリアンの店2号', 'sakana.jpg',4000,'最寄り駅から徒歩10分。美味しいお店です。', '272-0011', '愛知県市川市高谷新町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (13, 4,'イタリアンの店3号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。','130-0023', '愛知県墨田区立川X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (14, 4,'イタリアンの店4号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。','240-0006', '愛知県横浜市保土ヶ谷区星川X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (15, 4,'イタリアンの店5号', 'sakana.jpg',10000,'最寄り駅から徒歩10分。美味しいお店です。', '950-0201', '愛知県新潟市駒込X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (16, 10,'フレンチの店1号', 'sakana.jpg',10000,'最寄り駅から徒歩10分。美味しいお店です。', '939-8155', '愛知県富山市江本X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (17, 10,'フレンチの店2号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。', '929-0111', '愛知県能美市吉原町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (18, 10,'フレンチの店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '910-2354', '愛知県福井市東天田町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (19, 10,'フレンチの店4号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '403-0003', '愛知県富士吉田市大明見X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (20, 10,'フレンチの店5号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。', '395-0017', '愛知県飯田市東新町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (21, 3,'中華料理の店1号', 'sakana.jpg',1000, '最寄り駅から徒歩10分。美味しいお店です。',  '509-5147', '愛知県土岐市泉郷町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (22, 3,'中華料理の店2号', 'sakana.jpg',6000,'最寄り駅から徒歩10分。美味しいお店です。', '434-0002', '愛知県浜松市尾野X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (23, 3,'中華料理の店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。',  '444-3261', '愛知県豊田市東大林町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (24, 3, '中華料理の店4号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。', '510-0201', '愛知県鈴鹿市稲生町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (25, 3,'中華料理の店5号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '520-2353', '愛知県野洲市久野部X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (26, 8,'牛丼の店1号', 'sakana.jpg',500,'最寄り駅から徒歩10分。美味しいお店です。', '612-8369', '愛知県京都市伏見区村上町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (27, 8,'牛丼の店2号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '578-0915', '愛知県東大阪市古箕輪X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (28, 8,'牛丼の店3号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。', '655-0891', '愛知県神戸市垂水区山手X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (29, 8,'牛丼の店4号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '630-1126', '愛知県奈良市法用町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (30, 8,'牛丼の店5号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '640-8319', '愛知県和歌山市手平X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (31, 9,'居酒屋の店1号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '689-2203', '愛知県東伯郡北栄町原X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (32, 9,'居酒屋の店2号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。','694-0035', '愛知県大田市五十猛町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (33, 9,'居酒屋の店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '712-8036', '愛知県倉敷市水島西弥生町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (34, 9,'居酒屋の店4号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。',  '726-0011', '広島県府中市広谷町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (35, 9,'居酒屋の店5号', 'sakana.jpg',4000,'最寄り駅から徒歩10分。美味しいお店です。', '750-0451', '愛知県下関市豊田町阿座上X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (36, 15,'唐揚げの店1号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。', '778-0004', '愛知県三好市池田町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (37, 15,'唐揚げの店2号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '762-0067', '愛知県坂出市瀬居町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (38, 15,'唐揚げの店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。',  '792-0828', '愛知県新居浜市松原町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (39, 15,'唐揚げの店4号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。',  '787-1323', '愛知県四万十市西土佐中半X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (40, 15,'唐揚げの店5号', 'sakana.jpg',2000,'最寄り駅から徒歩10分。美味しいお店です。',  '835-0018', '愛知県みやま市瀬高町高柳X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (41, 16,'おにぎりの店1号', 'sakana.jpg',500, '最寄り駅から徒歩10分。美味しいお店です。', '840-0213', '愛知県佐賀市大和町久留間X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (42, 16,'おにぎりの店2号', 'sakana.jpg',200,'最寄り駅から徒歩10分。美味しいお店です。',  '852-8104', '愛知県長崎市茂里町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (43, 16,'おにぎりの店3号', 'sakana.jpg',1000, '最寄り駅から徒歩10分。美味しいお店です。', '863-0021', '愛知県天草市港町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (44, 16,'おにぎりの店4号', 'sakana.jpg',300,'最寄り駅から徒歩10分。美味しいお店です。', '872-0014', '愛知県宇佐市南鶴田新田X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (45, 16,'おにぎりの店5号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '880-0947', '愛知県宮崎市薫る坂X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (46, 2,'美味しい和食の店1号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。',  '895-2103', '愛知県薩摩郡さつま町紫尾X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (47, 2,'美味しい和食の店2号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '904-2165', '愛知県沖縄市宮里X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (48, 2,'美味しい和食の店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。',  '041-1121', '愛知県亀田郡七飯町大中山X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (49, 2,'美味しい和食の店4号', 'sakana.jpg',1000,'最寄り駅から徒歩10分。美味しいお店です。', '095-0019', '愛知県士別市大通東X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (50, 2,'美味しい和食の店5号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。', '099-0423', '愛知県紋別郡遠軽町若松X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (51, 1,'美味しい焼き肉の店1号', 'sakana.jpg',10000,'最寄り駅から徒歩10分。美味しいお店です。',  '089-0533', '愛知県中川郡幕別町札内新北町X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (52, 1,'美味しい焼き肉の店2号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。',  '049-3514', '愛知県山越郡長万部町富野X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (53, 1,'美味しい焼き肉の店3号', 'sakana.jpg',3000,'最寄り駅から徒歩10分。美味しいお店です。',  '066-0018', '愛知県千歳市旭ヶ丘X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (54, 1,'美味しい焼き肉の店4号', 'sakana.jpg',5000,'最寄り駅から徒歩10分。美味しいお店です。',  '003-0804', '愛知県札幌市白石区菊水四条X-XX-XX', '10:00～22:00', '012-345-678');
INSERT IGNORE INTO stores (id,category_id, name, image_name, price, description, postal_code, address, business_hours, phone_number)  VALUES (55, 1,'美味しい焼き肉の店5号', 'sakana.jpg',10000, '最寄り駅から徒歩10分。美味しいお店です。',  '042-0908', '愛知県函館市銅山町X-XX-XX', '10:00～22:00', '012-345-678');

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_PAID_MEMBERSHIP');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_FREE_MEMBERSHIP');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (1, 1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (2, 3, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (3, 2, '侍 義勝', 'サムライ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (4, 2,'侍 幸美', 'サムライ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (5, 2,'侍 雅', 'サムライ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (6, 2,'侍 正保', 'サムライ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.samurai@example.com', 'password',false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (7, 2,'侍 真由美', 'サムライ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (8, 2,'侍 安民', 'サムライ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (9, 2,'侍 章緒', 'サムライ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (10, 2,'侍 祐子', 'サムライ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (11, 2,'侍 秋美', 'サムライ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.samurai@example.com', 'password', false);
INSERT IGNORE INTO users (id, role_id, name, furigana, postal_code, address, phone_number, email, password, enabled) VALUES (12, 2,'侍 信平', 'サムライ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.samurai@example.com', 'password', false);

-- reservationテーブル
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (1, 1, 1, '2023-04-01','18:00', 2);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (2, 2, 1, '2023-04-01','18:00', 3);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (3, 3, 1, '2023-04-01','18:00', 4);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (4, 4, 1, '2023-04-01','18:00', 5);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (5, 5, 1, '2023-04-01','18:00', 6);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (6, 6, 1, '2023-04-01','18:00', 2);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (7, 7, 1, '2023-04-01','18:00', 3);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (8, 8, 1, '2023-04-01','18:00', 4);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (9, 9, 1, '2023-04-01','18:00', 5);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (10, 10, 1, '2023-04-01','18:00', 6);
INSERT IGNORE INTO reservation (id, store_id, user_id, reservation_date, reservation_time, number_of_people) VALUES (11, 11, 1, '2023-04-01','18:00', 2);

-- favoriteテーブル
INSERT IGNORE INTO favorite (id, store_id, user_id) VALUES (1, 1, 1);
INSERT IGNORE INTO favorite (id, store_id, user_id) VALUES (2, 2, 1);
INSERT IGNORE INTO favorite (id, store_id, user_id) VALUES (3, 3, 1);

-- reviewテーブル
INSERT IGNORE INTO review (id, store_id, user_id, review_comment) VALUES (1, 1, 1,'名古屋では有名な格安で焼肉食べ放題のお店。タイミングよく仕事で行く機会があったので、地元の友人と一緒に来店しました。店内は広くゆったりとできます。');
INSERT IGNORE INTO review (id, store_id, user_id,review_comment) VALUES (2, 2,1,'名古屋では有名な格安で焼肉食べ放題のお店。タイミングよく仕事で行く機会があったので、地元の友人と一緒に来店しました。店内は広くゆったりとできます。');
INSERT IGNORE INTO review (id, store_id, user_id,review_comment) VALUES (3, 3, 1,'名古屋では有名な格安で焼肉食べ放題のお店。タイミングよく仕事で行く機会があったので、地元の友人と一緒に来店しました。店内は広くゆったりとできます。');



