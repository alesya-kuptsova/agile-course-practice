package ru.unn.agile.interpolationsearch.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    private void setNumber(final Integer n) {
        viewModel.numberProperty().set(n.toString());
    }

    private void addNumber(final Integer n) {
        setNumber(n);
        viewModel.addNumber();
    }

    @Test
    public void isAddingValidInput() {
        addNumber(1);
        assertEquals(Integer.valueOf(1), viewModel.getArray().get(0));
    }

    @Test
    public void isAddingMultipleValidInput() {
        addNumber(1);
        addNumber(2);
        assertEquals(Integer.valueOf(1), viewModel.getArray().get(0));
        assertEquals(Integer.valueOf(2), viewModel.getArray().get(1));
    }

    @Test
    public void canDoSearch() {
        addNumber(1);
        addNumber(2);
        addNumber(3);
        viewModel.searchValueProperty().set("2");
        viewModel.doSearch();
        assertEquals("1", viewModel.getResult());
    }

    @Test
    public void canHandleEmptyList() {
        viewModel.searchValueProperty().set(Integer.toString(2));
        viewModel.doSearch();
        assertEquals("Empty list", viewModel.getResult());
    }

    @Test
    public void canHandleBadNumbers() {
        viewModel.numberProperty().set("2.5");
        viewModel.addNumber();
        assertEquals("Incorrect number", viewModel.getResult());
    }

    @Test
    public void canHandleBadValues() {
        addNumber(1);
        addNumber(2);
        viewModel.searchValueProperty().set("2.5");
        viewModel.doSearch();
        assertEquals("Incorrect value for search", viewModel.getResult());
    }

    @Test
    public void canHandleUnsortedArray() {
        addNumber(2);
        addNumber(1);
        viewModel.searchValueProperty().set("2");
        viewModel.doSearch();
        assertEquals("Array is not sorted", viewModel.getResult());
    }

    @Test
    public void canHandleBadSearch() {
        addNumber(1);
        addNumber(2);
        viewModel.searchValueProperty().set("3");
        viewModel.doSearch();
        assertEquals("Cannot find element '3' in array.", viewModel.getResult());
    }
}
