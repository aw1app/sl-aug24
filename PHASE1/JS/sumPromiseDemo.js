const { performance } = require('perf_hooks'); // Import performance from perf_hooks

// Function to sum natural numbers up to n
let sumNaturalNumber = (n) => {
    let sum = 0;
    for (let i = 0; i < n; i++) {
        sum = sum + i;
    }
    return sum;
};

// Function to simulate a delay
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

// Asynchronous function using a Promise to simulate long-running operations
function doSumAsynchronously(num, id) {
    return new Promise(async (resolve, reject) => {
        const startTime = performance.now(); // Record the start time in milliseconds (high-resolution)

        // Simulate a delay to ensure asynchronous behavior
        //await delay(Math.random() * 1000); // Random delay between 0 and 1000 ms

        // Simulate a long-running job
        let result = sumNaturalNumber(num);

        let jobSuccess = true; // Simulating job success
        const endTime = performance.now(); // Record the end time in milliseconds (high-resolution)

        if (jobSuccess) {
            resolve({ result, id, startTime, endTime });
        } else {
            reject(new Error(`Could not do the sum for Promise ${id}`));
        }
    });
}

// Function to demonstrate concurrent execution of async tasks
async function demonstrateAsynchronousBehavior() {
    console.log("Starting asynchronous tasks...");

    // Running promises concurrently
    const promises = [
        doSumAsynchronously(50000000000, 1),
        doSumAsynchronously(10000000000, 2),
        doSumAsynchronously(100000, 3),
        doSumAsynchronously(1000000, 4)
    ];

    // Using Promise.allSettled to handle resolved promises in order of completion
    Promise.all(promises).then((results) => {
        results.forEach(({ status, value, reason }) => {
            if (status === 'fulfilled') {
                const { result, id, startTime, endTime } = value;
                console.log(`Promise ${id} started at ${startTime.toFixed(3)} ms and ended at ${endTime.toFixed(3)} ms`);
                console.log(`Result of promise ${id}: ${result}`);
            } else {
                console.error(`Promise rejected: ${reason.message}`);
            }
        });
        console.log("All asynchronous tasks have been handled!");
    });

    console.log("All asynchronous tasks have been launched!");
}

// Run the demonstration
demonstrateAsynchronousBehavior();
