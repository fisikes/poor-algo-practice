fn heapify(arr: &mut [i32], index: usize, heap_size: usize) {
    let mut left = index * 2 + 1;// 左孩子下标

    while left < heap_size { // left下方还有孩子的时候
        // 计算左右孩子中的最大孩子
        let mut largest_index = if left + 1 < heap_size && arr[left + 1] > arr[left] { 
            left + 1 
        } else { left };

        largest_index = if arr[largest_index] > arr[index] {largest_index} else {index};

        if largest_index == index {
            break;
        }

        arr.swap(largest_index, index);

        left = largest_index * 2 + 1;

    }
}


#[test]
fn heapify_test() {
    // [3, 7, 8, 5, 4]
    //  0  1  2  3  4
    let mut arr = [3, 7, 8, 5, 4];
    println!("origin arr:{:?}", arr);
    let size = arr.len();

    heapify(&mut arr, 0, size);

    println!("target arr:{:?}", arr);

}