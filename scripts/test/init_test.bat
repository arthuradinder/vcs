:: scripts/test/init_test.bat
@echo off

:: Test repository initialization
echo Testing repository initialization...

:: Create test directory
set TEST_DIR=test_repo
rmdir /s /q %TEST_DIR% 2>nul
mkdir %TEST_DIR%
cd %TEST_DIR%

:: Initialize repository
java -jar ../../target/vcs.jar init

:: Verify .vcs directory exists
if exist ".vcs" (
    echo ✓ Repository initialized successfully
) else (
    echo ✗ Repository initialization failed
    exit /b 1
)
