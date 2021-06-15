package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SimpleStackTest {
    @Test
    public void testStack_whenStackIsCreated_thenNotNull() {
        SimpleStack stack = new SimpleStack();
        assertThat(stack).isNotNull();
    }

    @Test
    public void testSize_whenEmptyStack_thenZero() {
        SimpleStack stack = new SimpleStack();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void testSize_whenPushOneElementToEmptyStack_thenOne() {
        SimpleStack stack = new SimpleStack();
        stack.push(1);
        assertThat(stack.size()).isEqualTo(1);
    }

    // @Test /* test takes around 3 sec */
    public void testSize_whenPushTenMillionElementsToEmptyStack_thenSizeIsIntegerMaxElements() {
        SimpleStack stack = new SimpleStack();
        for (int element = 0; element < 10_000_000; element++) {
            stack.push(element);
        }
        assertThat(stack.size()).isEqualTo(10_000_000);
    }

    @Test
    public void testSize_whenPopElementFromNonEmptyStack_thenSizeIsDecreasedByOne() {
        SimpleStack stack = new SimpleStack();
        stack.push(1);
        stack.pop();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void testGetTail_whenEmptyStack_thenIsDummyNode() {
        SimpleStack stack = new SimpleStack();
        SimpleStack.Node<Integer> expectedDummyNode = new SimpleStack.Node<>(null, null);
        assertThat(stack.getTail()).isEqualTo(expectedDummyNode);
    }

    @Test
    public void testPush_whenPushNonNullElementToEmptyStack_thenTheTailIsNodeWithElement() {
        SimpleStack stack = new SimpleStack();
        SimpleStack.Node<Integer> formerTail = stack.getTail();
        assertThat(stack.push(1)).isTrue();
        SimpleStack.Node<Integer> expectedNode = new SimpleStack.Node<>(1, formerTail);
        assertThat(stack.getTail()).isEqualTo(expectedNode);
    }

    @Test
    public void testPush_whenPushNonNullElementToEmptyStack_thenNodeBeforeTailIsDummyNode() {
        SimpleStack stack = new SimpleStack();
        SimpleStack.Node<Integer> formerTail = stack.getTail();
        assertThat(stack.push(1)).isTrue();
        assertThat(stack.getTail().getPrevious()).isEqualTo(formerTail);
    }

    @Test
    public void testPop_whenEmptyStack_thenThrowsEmptyStackException() {
        SimpleStack stack = new SimpleStack();
        assertThatThrownBy(stack::pop).isInstanceOf(EmptyStackException.class);
    }

    @Test
    public void testPop_whenPopElementFromStackWithOneElement_thenElement() {
        SimpleStack stack = new SimpleStack();
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void testPop_whenPopElementFromStackWithOneElement_thenPreviousIsDummyNode() {
        SimpleStack stack = new SimpleStack();
        SimpleStack.Node<Integer> formerTail = stack.getTail();
        stack.push(1);
        stack.pop();
        assertThat(stack.getTail()).isEqualTo(formerTail);
    }

    @Test
    public void testPop_whenPopElementFromStackWithTwoElements_thenPreviousIsFirstlyAddedElement() {
        SimpleStack stack = new SimpleStack();
        stack.push(1);
        SimpleStack.Node<Integer> first = stack.getTail();
        stack.push(2);
        stack.pop();
        assertThat(stack.getTail()).isEqualTo(first);
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