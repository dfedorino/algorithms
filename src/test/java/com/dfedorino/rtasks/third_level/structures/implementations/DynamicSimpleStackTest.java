package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DynamicSimpleStackTest {

    @Test
    public void testStack_whenStackIsCreated_thenNotNull() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        assertThat(stack).isNotNull();
    }

    @Test
    public void testSize_whenEmptyStack_thenZero() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void testSize_whenPushOneElementToEmptyStack_thenOne() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        assertThat(stack.size()).isEqualTo(1);
    }

    // @Test /* test takes around 3 sec */
    public void testSize_whenPushTenMillionElementsToEmptyStack_thenSizeIsIntegerMaxElements() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        for (int element = 0; element < 10_000_000; element++) {
            stack.push(element);
        }
        assertThat(stack.size()).isEqualTo(10_000_000);
    }

    @Test
    public void testSize_whenPopElementFromNonEmptyStack_thenSizeIsDecreasedByOne() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        stack.pop();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    public void testSize_whenTopElementFromNonEmptyStack_thenSizeIsSame() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        int expectedSize = stack.size();
        stack.top();
        assertThat(stack.size()).isEqualTo(expectedSize);
    }

    @Test
    public void testGetTail_whenEmptyStack_thenIsDummyNode() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        DynamicSimpleStack.Node<Integer> expectedDummyNode = new DynamicSimpleStack.Node<>(null, null);
        assertThat(stack.getTail()).isEqualTo(expectedDummyNode);
    }

    @Test
    public void testPush_whenPushNonNullElementToEmptyStack_thenTheTailIsNodeWithElement() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        DynamicSimpleStack.Node<Integer> formerTail = stack.getTail();
        assertThat(stack.push(1)).isTrue();
        DynamicSimpleStack.Node<Integer> expectedNode = new DynamicSimpleStack.Node<>(1, formerTail);
        assertThat(stack.getTail()).isEqualTo(expectedNode);
    }

    @Test
    public void testPush_whenPushNonNullElementToEmptyStack_thenNodeBeforeTailIsDummyNode() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        DynamicSimpleStack.Node<Integer> formerTail = stack.getTail();
        assertThat(stack.push(1)).isTrue();
        assertThat(stack.getTail().getPrevious()).isEqualTo(formerTail);
    }

    @Test
    public void testPop_whenEmptyStack_thenThrowsEmptyStackException() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        assertThatThrownBy(stack::pop).isInstanceOf(EmptyStackException.class);
    }

    @Test
    public void testPop_whenPopElementFromStackWithOneElement_thenElement() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void testPop_whenPopElementFromStackWithOneElement_thenPreviousIsDummyNode() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        DynamicSimpleStack.Node<Integer> formerTail = stack.getTail();
        stack.push(1);
        stack.pop();
        assertThat(stack.getTail()).isEqualTo(formerTail);
    }

    @Test
    public void testPop_whenPopElementFromStackWithTwoElements_thenPreviousIsFirstlyAddedElement() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        DynamicSimpleStack.Node<Integer> first = stack.getTail();
        stack.push(2);
        stack.pop();
        assertThat(stack.getTail()).isEqualTo(first);
    }

    @Test
    public void testTop_whenTopElementFromStackWithOneElement_thenLastElementValue() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        int expectedValue = 1;
        stack.push(expectedValue);
        assertThat(stack.top()).isEqualTo(1);
    }

    @Test
    public void testTop_whenEmptyStack_thenThrowsEmptyStackException() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        assertThatThrownBy(stack::top).isInstanceOf(EmptyStackException.class);
    }

    @Test
    public void testClear_whenNonEmptyStack_thenNoExceptionIsThrown() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        assertThatCode(stack::clear).doesNotThrowAnyException();
    }

    @Test
    public void testClear_whenNonEmptyStack_thenTailIsNullPreviousIsNull() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        DynamicSimpleStack.Node<Integer> dummyNode = stack.getTail();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        assertThat(stack.getTail()).isEqualTo(dummyNode);
    }

    @Test
    public void testClear_whenNonEmptyStack_thenSizeIsZero() {
        DynamicSimpleStack stack = new DynamicSimpleStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        assertThat(stack.size()).isEqualTo(0);
    }

    // Node Tests

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNullPrevious_thenElementIsNull() {
        DynamicSimpleStack.Node<Integer> node = new DynamicSimpleStack.Node<>(null, null);
        assertThat(node.getElement()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNullPrevious_thenPreviousIsNull() {
        DynamicSimpleStack.Node<Integer> node = new DynamicSimpleStack.Node<>(null, null);
        assertThat(node.getPrevious()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNonNullContentAndNullPrevious_thenElementIsEqualToExpected() {
        DynamicSimpleStack.Node<Integer> node = new DynamicSimpleStack.Node<>(1, null);
        assertThat(node.getElement()).isEqualTo(1);
        assertThat(node.getPrevious()).isNull();
    }

    @Test
    public void testNode_whenConstructNodeWithNullContentAndNonNullPrevious_thenPreviousPointsAtTheSameObject() {
        DynamicSimpleStack.Node<Integer> previous = new DynamicSimpleStack.Node<>(1, null);
        DynamicSimpleStack.Node<Integer> node = new DynamicSimpleStack.Node<>(2, previous);
        assertThat(node.getPrevious() == previous).isTrue();
    }

    @Test
    public void testNode_whenConstructTwoEmptyNodes_thenTheyAreEqual() {
        DynamicSimpleStack.Node<Integer> first = new DynamicSimpleStack.Node<>(null, null);
        DynamicSimpleStack.Node<Integer> second = new DynamicSimpleStack.Node<>(null, null);
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void testNode_whenConstructTwoEqualNodes_thenEqualsReturnTrueAndHashCodesAreSameAndViceVersa() {
        DynamicSimpleStack.Node<Integer> first = new DynamicSimpleStack.Node<>(1, null);
        DynamicSimpleStack.Node<Integer> second = new DynamicSimpleStack.Node<>(1, null);
        assertThat(first.equals(second)).isTrue();
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
        assertThat(second.equals(first)).isTrue();
        assertThat(second.hashCode()).isEqualTo(first.hashCode());
    }

    @Test
    public void testNode_whenConstructTwoNonEqualNodes_thenEqualsReturnFalseAndViceVersa() {
        DynamicSimpleStack.Node<Integer> first = new DynamicSimpleStack.Node<>(1, null);
        DynamicSimpleStack.Node<Integer> second = new DynamicSimpleStack.Node<>(2, null);
        assertThat(first.equals(second)).isFalse();
        assertThat(second.equals(first)).isFalse();
    }
}