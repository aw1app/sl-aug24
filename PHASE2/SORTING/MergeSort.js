function mergeSort(array) {
    // Base case: 
    if (array.length <= 1) return array;

    // Find the middle index of the array 
    const middleIndex = Math.floor(array.length / 2);

    // Divide the array into two halves 
    const leftHalf = array.slice(0, middleIndex);
    const rightHalf = array.slice(middleIndex);

    // Recursively sort the left and right halves 
    const sortedLeft = mergeSort(leftHalf);
    const sortedRight = mergeSort(rightHalf);

    return merge(sortedLeft, sortedRight);
}

function merge(leftArray, rightArray) {
    const mergedArray = [];
    let leftIndex = 0;
    let rightIndex = 0;

    // Merge the two sorted arrays 
    while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
        if (leftArray[leftIndex] <= rightArray[rightIndex]) {
            mergedArray.push(leftArray[leftIndex]);
            leftIndex++;
        } else {
            mergedArray.push(rightArray[rightIndex]);
            rightIndex++
        }
    }

    // if there are any remaining elements in either of the array
    return mergedArray.concat(leftArray.slice(leftIndex)).concat(rightArray.slice(rightIndex));
}

const unsortedArray = [5, 2, 4, 17, 23, 1, 3];
console.log("Before Sorting");
console.log(unsortedArray);
sortedArray = mergeSort(unsortedArray);
console.log("AFTER mergeSort Sorting");
console.log(sortedArray);