# Test repository initialization
echo "Testing repository initialization..."

# Create test directory
TEST_DIR="test_repo"
rm -rf $TEST_DIR
mkdir $TEST_DIR
cd $TEST_DIR

# Initialize repository
java -jar ../../target/sourcecontrolsystem.jar init

# Verify .vcs directory exists
if [ -d ".vcs" ]; then
    echo "✓ Repository initialized successfully"
else
    echo "✗ Repository initialization failed"
    exit 1
fi
