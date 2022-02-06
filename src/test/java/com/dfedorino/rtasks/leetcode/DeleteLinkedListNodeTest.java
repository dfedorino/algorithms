package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteLinkedListNodeTest {
    private final DeleteLinkedListNode solution = new DeleteLinkedListNode();
    DeleteLinkedListNode.ListNode headNode = null;
    DeleteLinkedListNode.ListNode secondNode = null;
    DeleteLinkedListNode.ListNode thirdNode = null;
    DeleteLinkedListNode.ListNode fourthNode = null;

    @BeforeMethod
    public void setUp() {
        headNode = new DeleteLinkedListNode.ListNode(4);
        secondNode = new DeleteLinkedListNode.ListNode(5);
        thirdNode = new DeleteLinkedListNode.ListNode(1);
        fourthNode = new DeleteLinkedListNode.ListNode(9);
        headNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
    }

    @Test
    void when_delete_head_node_then_array_of_values_without_deleted_value() {
        // TODO: fix me
        assertThat(collectListValues(headNode)).isEqualTo("[4,5,1,9]");
        solution.deleteNode(headNode);
        String expectedCollectedValues = "[5,1,9]";
        assertThat(collectListValues(headNode)).isEqualTo(expectedCollectedValues);
    }

    @Test
    void when_delete_even_node_then_array_of_values_without_deleted_value() {
        assertThat(collectListValues(headNode)).isEqualTo("[4,5,1,9]");
        solution.deleteNode(secondNode);
        String expectedCollectedValues = "[4,1,9]";
        assertThat(collectListValues(headNode)).isEqualTo(expectedCollectedValues);
    }

    @Test
    void when_delete_odd_node_then_array_of_values_without_deleted_value() {
        assertThat(collectListValues(headNode)).isEqualTo("[4,5,1,9]");
        solution.deleteNode(thirdNode);
        String expectedCollectedValues = "[4,5,9]";
        assertThat(collectListValues(headNode)).isEqualTo(expectedCollectedValues);
    }

    private String collectListValues(DeleteLinkedListNode.ListNode headNode) {
        StringBuilder listValues = new StringBuilder("[");
        DeleteLinkedListNode.ListNode currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.next == null) {
                listValues.append(currentNode.val);
            } else {
                listValues.append(currentNode.val).append(",");
            }
            currentNode = currentNode.next;
        }
        listValues.append("]");
        return listValues.toString();
    }
}