/* V2__seed_data.sql */

/* University (10개) */
INSERT INTO university (email_domain, name) VALUES
('univ1.ac.kr', '한국대학교'),
('univ2.ac.kr', '서울대학교'),
('univ3.ac.kr', '연세대학교'),
('univ4.ac.kr', '고려대학교'),
('univ5.ac.kr', '성균관대학교'),
('univ6.ac.kr', '한양대학교'),
('univ7.ac.kr', '서강대학교'),
('univ8.ac.kr', '중앙대학교'),
('univ9.ac.kr', '경희대학교'),
('univ10.ac.kr', '한국외국어대학교');

/* User (10개 - 관리자 1, 학생회 3, 점주 3, 학생 3) */
/* 비밀번호 '0000'의 BCrypt Hash: $2a$10$Op.1... (To be replaced with actual hash from tool output) */
/* 사용자명 변경: admin1 -> admin, council1 -> council, owner1 -> owner, student1 -> student */
INSERT INTO user (username, password, name, phone, role, created_at, modified_at, gender) VALUES
('admin', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '관리자', '010-0000-0000', 'ROLE_ADMIN', NOW(), NOW(), 1),
('council', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '총학생회장', '010-1111-1111', 'ROLE_COUNCIL', NOW(), NOW(), 1),
('council2', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '공대학생회장', '010-2222-2222', 'ROLE_COUNCIL', NOW(), NOW(), 0),
('council3', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '경영대학생회장', '010-3333-3333', 'ROLE_COUNCIL', NOW(), NOW(), 1),
('owner', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '김점주', '010-4444-4444', 'ROLE_OWNER', NOW(), NOW(), 0),
('owner2', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '이점주', '010-5555-5555', 'ROLE_OWNER', NOW(), NOW(), 1),
('owner3', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '박점주', '010-6666-6666', 'ROLE_OWNER', NOW(), NOW(), 0),
('student', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '김학생', '010-7777-7777', 'ROLE_STUDENT', NOW(), NOW(), 1),
('student2', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '이학생', '010-8888-8888', 'ROLE_STUDENT', NOW(), NOW(), 0),
('student3', '$2b$12$ilUslC664yQIdJgyIhHxkOzJl1LXl1VkdXqXF22TjO3YGjAhJz9ze', '박학생', '010-9999-9999', 'ROLE_STUDENT', NOW(), NOW(), 1);

/* Council Profile (3개) */
INSERT INTO council_profile (user_id, university_id) VALUES
(2, 1),
(3, 1),
(4, 2);

/* Owner Profile (3개) */
INSERT INTO owner_profile (user_id, name, phone, email) VALUES
(5, '김점주', '010-4444-4444', 'owner1@test.com'),
(6, '이점주', '010-5555-5555', 'owner2@test.com'),
(7, '박점주', '010-6666-6666', 'owner3@test.com');

/* Student Profile (3개) */
INSERT INTO student_profile (user_id, university_id, nickname) VALUES
(8, 1, '새내기1'),
(9, 1, '헌내기2'),
(10, 2, '졸업반3');

/* Organization (10개) */
INSERT INTO organization (university_id, user_id, name, category, created_at, modified_at) VALUES
(1, 2, '한국대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 1
(1, 3, '한국대 공과대학', 'COLLEGE', NOW(), NOW()), -- ID 2
(1, 3, '한국대 컴퓨터공학과', 'DEPARTMENT', NOW(), NOW()), -- ID 3
(2, 4, '서울대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 4
(2, 4, '서울대 경영대학', 'COLLEGE', NOW(), NOW()), -- ID 5
(3, 1, '연세대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 6
(4, 1, '고려대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 7
(5, 1, '성균관대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 8
(6, 1, '한양대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()), -- ID 9
(7, 1, '서강대 총학생회', 'STUDENT_COUNCIL', NOW(), NOW()); -- ID 10

/* User Organization (Link Users to Orgs) */
INSERT INTO user_organization (user_id, organization_id) VALUES
(2, 1), (3, 2), (4, 4);

/* Store (10개) */
INSERT INTO store (user_id, name, branch, road_address, jibun_address, biz_reg_no, store_phone, introduction, operating_hours, store_status, need_to_check, check_reason, latitude, longitude, created_at, modified_at) VALUES
(5, '맛있는 파스타', '본점', '서울시 강남구 역삼동 1', '서울시 강남구 역삼동 100-1', '123-45-78901', '02-1234-5678', '정통 이탈리안 파스타 전문점입니다.', '매일 11:00 - 22:00', 'ACTIVE', 0, NULL, 37.498095, 127.027610, NOW(), NOW()),
(5, '시원한 카페', '대학로점', '서울시 종로구 명륜동 2', '서울시 종로구 명륜동 200-2', '234-56-89012', '02-2345-6789', '넓고 쾌적한 스터디하기 좋은 카페', '매일 09:00 - 23:00', 'ACTIVE', 0, NULL, 37.588284, 126.992224, NOW(), NOW()),
(6, '매운 떡볶이', '신촌점', '서울시 서대문구 대현동 3', '서울시 서대문구 대현동 300-3', '345-67-90123', '02-3456-7890', '스트레스 확 풀리는 매운맛!', '매일 14:00 - 02:00', 'ACTIVE', 0, NULL, 37.556754, 126.945892, NOW(), NOW()),
(6, '든든 국밥', '안암점', '서울시 성북구 안암동 4', '서울시 성북구 안암동 400-4', '456-78-01234', '02-4567-8901', '24시간 정성껏 끓인 국밥', '24시간 영업', 'ACTIVE', 0, NULL, 37.586419, 127.029053, NOW(), NOW()),
(7, '바삭 치킨', '왕십리점', '서울시 성동구 행당동 5', '서울시 성동구 행당동 500-5', '567-89-12345', '02-5678-9012', '겉바속촉 치킨의 정석', '매일 16:00 - 04:00', 'ACTIVE', 0, NULL, 37.561726, 127.037409, NOW(), NOW()),
(7, '피자 천국', '흑석점', '서울시 동작구 흑석동 6', '서울시 동작구 흑석동 600-6', '678-90-23456', '02-6789-0123', '토핑이 듬뿍 들어간 수제 피자', '매일 11:30 - 23:30', 'ACTIVE', 0, NULL, 37.508821, 126.963784, NOW(), NOW()),
(null, '버거 대장', '회기점', '서울시 동대문구 회기동 7', '서울시 동대문구 회기동 700-7', '789-01-34567', '02-7890-1234', '육즙 가득한 수제 버거 맛집', '매일 10:30 - 21:00', 'UNCLAIMED', 0, NULL, 37.589808, 127.057913, NOW(), NOW()),
(null, '초밥 달인', '이문동점', '서울시 동대문구 이문동 8', '서울시 동대문구 이문동 800-8', '890-12-45678', '02-8901-2345', '신선한 재료로 만드는 프리미엄 초밥', '매일 11:30 - 22:00, 브레이크타임 15:00-17:00', 'UNCLAIMED', 0, NULL, 37.595605, 127.062831, NOW(), NOW()),
(null, '감성 포차', '신수동점', '서울시 마포구 신수동 9', '서울시 마포구 신수동 900-9', '901-23-56789', '02-9012-3456', '분위기 좋은 감성 요리 주점', '매일 18:00 - 05:00', 'UNCLAIMED', 0, NULL, 37.547146, 126.936551, NOW(), NOW()),
(null, '달콤 베이커리', '성수점', '서울시 성동구 성수동 10', '서울시 성동구 성수동 1000-10', '012-34-67890', '02-0123-4567', '매일 아침 구워내는 신선한 빵', '매일 08:00 - 21:00', 'UNCLAIMED', 0, NULL, 37.544569, 127.056073, NOW(), NOW());

/* Store University (Link Stores to Universities) */
INSERT INTO store_university (store_id, university_id) VALUES
(1, 1), (2, 5), (3, 3), (4, 4), (5, 6), (6, 8), (7, 9), (8, 10), (9, 7), (10, 6);

/* Partnership (10개) */
INSERT INTO partnership (organization_id, store_id, benefit, starts_at, ends_at, created_at, modified_at) VALUES
(1, 1, '테이블당 음료수 1개 서비스', '2024-01-01', '2024-12-31', NOW(), NOW()),
(8, 2, '모든 음료 10% 할인', '2024-02-01', '2024-12-31', NOW(), NOW()),
(6, 3, '세트 메뉴 2000원 할인', '2024-03-01', '2025-02-28', NOW(), NOW()),
(7, 4, '공기밥 무한 리필', '2024-01-01', '2024-06-30', NOW(), NOW()),
(9, 5, '포장 주문 시 2000원 할인', '2024-01-01', '2024-12-31', NOW(), NOW()),
(10, 6, '치즈 토핑 무료', '2024-04-01', '2024-12-31', NOW(), NOW()),
(2, 1, '학생증 제시 시 5% 추가 할인', '2024-01-01', '2024-12-31', NOW(), NOW()),
(4, 3, '쿨피스 무료 증정', '2024-01-01', '2024-12-31', NOW(), NOW()),
(3, 1, '학과 행사 시 단체석 우선 예약', '2024-01-01', '2024-12-31', NOW(), NOW()),
(5, 4, '수육 주문 시 소주 1병', '2024-01-01', '2024-12-31', NOW(), NOW());

/* Item (10개 - Store 1~3 위주) */
INSERT INTO item (store_id, name, price, is_sold_out, is_hidden, is_representative, created_at, modified_at) VALUES
(1, '까르보나라', 12000, 0, 0, 1, NOW(), NOW()),
(1, '알리오 올리오', 10000, 0, 0, 0, NOW(), NOW()),
(1, '토마토 파스타', 11000, 0, 0, 0, NOW(), NOW()),
(2, '아메리카노', 4000, 0, 0, 1, NOW(), NOW()),
(2, '카페라떼', 4500, 0, 0, 0, NOW(), NOW()),
(3, '떡볶이 1인분', 4000, 0, 0, 1, NOW(), NOW()),
(3, '모듬 튀김', 5000, 0, 0, 0, NOW(), NOW()),
(4, '순대국밥', 9000, 0, 0, 1, NOW(), NOW()),
(5, '후라이드 치킨', 18000, 0, 0, 1, NOW(), NOW()),
(6, '콤비네이션 피자', 20000, 0, 0, 1, NOW(), NOW());

/* Coupon (10개) */
INSERT INTO coupon (store_id, title, total_quantity, limit_per_user, status, created_at, modified_at) VALUES
(1, '오픈 기념 10% 할인', 100, 1, 'ACTIVE', NOW(), NOW()),
(2, '신메뉴 무료 시음권', 50, 1, 'ACTIVE', NOW(), NOW()),
(3, '떡볶이 사이즈 업', 100, 1, 'ACTIVE', NOW(), NOW()),
(4, '음료수 무료 쿠폰', 200, 2, 'ACTIVE', NOW(), NOW()),
(5, '생맥주 500cc 1잔', 100, 1, 'ACTIVE', NOW(), NOW()),
(6, '사이드 메뉴 1종 무료', 50, 1, 'ACTIVE', NOW(), NOW()),
(7, '무료 토핑 추가', 100, 1, 'ACTIVE', NOW(), NOW()),
(1, '재방문 5% 할인', 1000, 10, 'ACTIVE', NOW(), NOW()),
(2, '아메리카노 1+1', 50, 1, 'EXPIRED', NOW(), NOW()),
(3, '튀김 서비스', 10, 1, 'STOPPED', NOW(), NOW());

/* Review (10개) */
INSERT INTO review (store_id, user_id, rating, content, is_verified, is_private, like_count, report_count, status, created_at, modified_at) VALUES
(1, 8, 5, '정말 맛있어요!', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(1, 9, 4, '가성비 좋습니다.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(2, 10, 5, '커피 향이 너무 좋아요.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(2, 8, 3, '자리가 좀 좁아요.', 0, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(3, 9, 5, '매운데 맛있네요.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(3, 10, 4, '튀김이 바삭합니다.', 0, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(4, 8, 5, '국밥이 정말 든든해요.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(5, 9, 5, '치맥하기 딱 좋습니다.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(6, 10, 2, '배달이 너무 늦었어요.', 0, 0, 0, 0, 'PUBLISHED', NOW(), NOW()),
(1, 8, 5, '또 가고 싶어요.', 1, 0, 0, 0, 'PUBLISHED', NOW(), NOW());

/* Review Like (10개) */
INSERT INTO review_like (review_id, user_id, created_at, modified_at) VALUES
(1, 9, NOW(), NOW()), (1, 10, NOW(), NOW()),
(2, 8, NOW(), NOW()), (3, 8, NOW(), NOW()),
(5, 8, NOW(), NOW()), (5, 10, NOW(), NOW()),
(7, 9, NOW(), NOW()), (7, 10, NOW(), NOW()),
(8, 8, NOW(), NOW()), (8, 9, NOW(), NOW());

/* Store Claim (10개 - 5 PENDING, 3 APPROVED, 2 REJECTED) */
INSERT INTO store_claim (store_id, user_id, biz_reg_no, representative_name, store_name, license_image_url, status, created_at, modified_at) VALUES
(7, 5, '123-45-67890', '김점주', '버거 대장', 'http://img.com/1', 'PENDING', NOW(), NOW()),
(8, 6, '234-56-78901', '이점주', '초밥 달인', 'http://img.com/2', 'PENDING', NOW(), NOW()),
(9, 7, '345-67-89012', '박점주', '감성 포차', 'http://img.com/3', 'PENDING', NOW(), NOW()),
(10, 5, '456-78-90123', '김점주', '달콤 베이커리', 'http://img.com/4', 'PENDING', NOW(), NOW()),
(1, 5, '000-00-00000', '김점주', '맛있는 파스타', 'http://img.com/5', 'APPROVED', NOW(), NOW()), -- Already owner of Store 1
(2, 5, '000-00-00001', '김점주', '시원한 카페', 'http://img.com/6', 'APPROVED', NOW(), NOW()), -- Already owner of Store 2
(3, 6, '000-00-00002', '이점주', '매운 떡볶이', 'http://img.com/7', 'APPROVED', NOW(), NOW()), -- Already owner of Store 3
(1, 6, '111-11-11111', '이점주', '맛있는 파스타', 'http://img.com/8', 'REJECTED', NOW(), NOW()), -- Reject
(7, 6, '222-22-22222', '이점주', '버거 대장', 'http://img.com/9', 'REJECTED', NOW(), NOW()), -- Reject
(9, 5, '333-33-33333', '김점주', '감성 포차', 'http://img.com/10', 'PENDING', NOW(), NOW());
