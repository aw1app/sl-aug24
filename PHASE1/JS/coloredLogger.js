// coloredLogger.js

// Function to log messages in red
function logRed(message) {
  console.log("\x1b[31m%s\x1b[0m", message);
}

// Function to log messages in green
function logGreen(message) {
  console.log("\x1b[32m%s\x1b[0m", message);
}

// Function to log messages in yellow
function logYellow(message) {
  console.log("\x1b[33m%s\x1b[0m", message);
}

// Function to log messages in blue
function logBlue(message) {
  console.log("\x1b[34m%s\x1b[0m", message);
}

// Function to log messages with a red background and white text
function logRedBg(message) {
  console.log("\x1b[41m\x1b[37m%s\x1b[0m", message); // Red background, white text
}

// Function to log messages with a green background and black text
function logGreenBg(message) {
  console.log("\x1b[42m\x1b[30m%s\x1b[0m", message); // Green background, black text
}

// Function to log messages with a yellow background and black text
function logYellowBg(message) {
  console.log("\x1b[43m\x1b[30m%s\x1b[0m", message); // Yellow background, black text
}

// Function to log messages with a blue background and white text
function logBlueBg(message) {
  console.log("\x1b[44m\x1b[37m%s\x1b[0m", message); // Blue background, white text
}
