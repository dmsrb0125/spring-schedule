DROP TABLE IF EXISTS memo CASCADE;

-- Create the memo table
CREATE TABLE memo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    contents TEXT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date DATE NOT NULL
);

-- Insert example data into the memo table
INSERT INTO memo (title, contents, username, password, date) VALUES
('할 일 1', '할 일 1의 내용입니다.', 'user1', 'password1', '2024-01-01'),
('할 일 2', '할 일 2의 내용입니다.', 'user2', 'password2', '2024-01-02'),
('할 일 3', '할 일 3의 내용입니다.', 'user3', 'password3', '2024-01-03');
