package rs.volleybox.backend.so;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rs.volleybox.backend.database.DBBroker;

abstract class SOClassTest {

    @Mock
    protected DBBroker dbb;

    protected SOClass so;
    protected abstract void createSO();

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        createSO();
        so.setDbbroker(dbb);
    }

    @AfterEach
    void tearDown() throws Exception {
        so = null;
        dbb = null;
    }


}
