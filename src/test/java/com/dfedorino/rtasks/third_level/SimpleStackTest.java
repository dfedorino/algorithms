package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleStackTest {
    @Test
    public void testStack_whenStackIsCreated_thenItIsNotNull() {
        SimpleStack stack = new SimpleStack();
        assertThat(stack).isNotNull();
    }

    @Test
    public void testStack_whenSizeIsCalledOnAnEmptyStack_thenTheSizeIsZero() {
        SimpleStack stack = new SimpleStack();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void testStack_whenGetTailIsCalledOnAnEmptyStack_thenTheTailIsDummyNode() {
        SimpleStack stack = new SimpleStack();
        SimpleStack.Node<Integer> expectedDummyNode = new SimpleStack.Node<>(null, null);
        assertThat(stack.getTail()).isEqualTo(expectedDummyNode);
    }

    // Node Tests

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNullPrevious_thenElementIsNull() {
        SimpleStack.Node<Integer> node = new SimpleStack.Node<>(null, null);
        assertThat(node.getElement()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNullPrevious_thenPreviousIsNull() {
        SimpleStack.Node<Integer> node = new SimpleStack.Node<>(null, null);
        assertThat(node.getPrevious()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNonNullContentAndNullPrevious_thenElementIsEqualToExpected() {
        SimpleStack.Node<Integer> node = new SimpleStack.Node<>(1, null);
        assertThat(node.getElement()).isEqualTo(1);
        assertThat(node.getPrevious()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNonNullPrevious_thenPreviousPointsAtTheSameObject() {
        SimpleStack.Node<Integer> previous = new SimpleStack.Node<>(1, null);
        SimpleStack.Node<Integer> node = new SimpleStack.Node<>(2, previous);
        assertThat(node.getPrevious() == previous).isTrue();
    }

    @Test
    public void testNode_whenConstructTwoEmptyNodes_thenTheyAreEqual() {
        SimpleStack.Node<Integer> first = new SimpleStack.Node<>(null, null);
        SimpleStack.Node<Integer> second = new SimpleStack.Node<>(null, null);
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void testNode_whenConstructTwoEqualNodes_thenEqualsReturnTrueAndHashCodesAreSameAndViceVersa() {
        SimpleStack.Node<Integer> first = new SimpleStack.Node<>(1, null);
        SimpleStack.Node<Integer> second = new SimpleStack.Node<>(1, null);
        assertThat(first.equals(second)).isTrue();
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
        assertThat(second.equals(first)).isTrue();
        assertThat(second.hashCode()).isEqualTo(first.hashCode());
    }

    @Test
    public void testNode_whenConstructTwoNonEqualNodes_thenEqualsReturnFalseAndViceVersa() {
        SimpleStack.Node<Integer> first = new SimpleStack.Node<>(1, null);
        SimpleStack.Node<Integer> second = new SimpleStack.Node<>(2, null);
        assertThat(first.equals(second)).isFalse();
        assertThat(second.equals(first)).isFalse();
    }
}