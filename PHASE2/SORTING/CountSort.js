function countingSort(arr) {
    // Create a copy of input array
    const result = [];
    const maxVal = Math.max(...arr);
    const count = new Array(maxVal + 1).fill(0);

    // Count occurrences
    for (const num of arr) {
        count[num] += 1;
    }

    //console.log(count)

    // Build sorted array
    for (let i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            result.push(i);
            count[i] -= 1;
        }
    }

    return result;
}

// Example usage:
const unsortedArr = [4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3];
console.log("Original array:", unsortedArr);


// Using idiomatic version
const sortedArr2 = countingSort(unsortedArr);
console.log("Sorted array (idiomatic):", sortedArr2);