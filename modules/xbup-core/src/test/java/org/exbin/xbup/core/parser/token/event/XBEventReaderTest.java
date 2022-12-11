/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.core.parser.token.event;

import java.io.IOException;
import java.io.InputStream;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.exbin.xbup.core.parser.XBParsingException;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.basic.convert.XBConsumerToListener;
import org.exbin.xbup.core.parser.basic.convert.XBPrintFilter;
import org.exbin.xbup.core.parser.data.XBCoreTestSampleData;
import org.exbin.xbup.core.parser.token.event.convert.XBListenerToEventListener;
import org.exbin.xbup.core.parser.token.event.convert.XBPrintEventFilter;
import org.exbin.xbup.core.test.XBTestUtils.BufferAssertXBFilter;
import org.junit.Test;

/**
 * Test class for XBEventReader.
 *
 * @author ExBin Project (https://exbin.org)
 */
public class XBEventReaderTest extends TestCase {

    public XBEventReaderTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleEmpty() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_EMPTY)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleEmpty(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlock() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlock(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockTerminated() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockTerminated(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockTerminatedWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_TERMINATED_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockTerminatedWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleData() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleData(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleDataWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleDataWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleDataTerminated() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleDataTerminated(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleDataTerminatedWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_TERMINATED_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleDataTerminatedWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockData() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockData(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockDataWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockDataWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockDataTerminated() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockDataTerminated(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockDataTerminatedWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_TERMINATED_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockDataTerminatedWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockDataHybrid() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_HYBRID)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockDataHybrid(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleBlockDataHybrid2() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_HYBRID2)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleBlockDataHybrid2(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocks() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocks(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocksWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocksWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocksTerminated() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocksTerminated(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocksTerminatedWithTail() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_TERMINATED_WITH_TAIL)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocksTerminatedWithTail(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocksHybrid() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_HYBRID)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocksHybrid(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleTwoBlocksHybrid2() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_HYBRID2)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleTwoBlocksHybrid2(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSampleSixBlocks() throws Exception {
        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_SIX_BLOCKS)) {
            XBEventReader instance = new XBEventReader(stream);
            BufferAssertXBFilter assertListener;
            XBConsumerToListener buffer = new XBConsumerToListener(null);
            XBCoreTestSampleData.writeSampleSixBlocks(buffer);
            assertListener = new BufferAssertXBFilter(buffer.getTokens());

            instance.attachXBEventListener(new XBListenerToEventListener(new XBPrintFilter(assertListener)));
            instance.read();
            assertTrue(assertListener.isFinished());
        }
    }

    /**
     * Tests XBEventReader class reading corrupted empty file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedEmpty() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_EMPTY)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBProcessingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted single byte data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedSingleByte() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_SINGLE_BYTE)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBProcessingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted wrong header.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedWrongHeader() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_WRONG_HEADER)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Unsupported header: 0xfe0059420002", XBProcessingExceptionType.CORRUPTED_HEADER), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedIncompleteBlock() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_INCOMPLETE_BLOCK)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedIncompleteBlock2() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_INCOMPLETE_BLOCK2)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedIncompleteBlockTerminated() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_INCOMPLETE_BLOCK_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedIncompleteData() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_INCOMPLETE_DATA)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Unexpected end of stream", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedIncompleteDataTerminated() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_INCOMPLETE_DATA_TERMINATED)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Missing data block terminator", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedUnexpectedTerminator() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_UNEXPECTED_TERMINATOR)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Unexpected terminator", XBProcessingExceptionType.UNEXPECTED_TERMINATOR), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedUnexpectedTerminator2() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_UNEXPECTED_TERMINATOR2)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Unexpected terminator", XBProcessingExceptionType.UNEXPECTED_TERMINATOR), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedChildOverflow() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_CHILD_OVERFLOW)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Block overflow", XBProcessingExceptionType.BLOCK_OVERFLOW), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedAttributeOverflow() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_ATTRIBUTE_OVERFLOW)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Attribute overflow", XBProcessingExceptionType.ATTRIBUTE_OVERFLOW), ex);
        }
    }

    /**
     * Tests XBEventReader class reading corrupted file.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testReadCorruptedDataOverflow() throws Exception {
        Throwable ex = null;

        try (InputStream stream = XBEventReaderTest.class.getResourceAsStream(XBCoreTestSampleData.CORRUPTED_DATA_OVERFLOW)) {
            XBEventReader instance = new XBEventReader(stream);
            try {
                instance.attachXBEventListener(new XBPrintEventFilter(null));
                instance.read();
            } catch (XBProcessingException | IOException e) {
                ex = e;
            }

            assertEquals(new XBParsingException("Block overflow", XBProcessingExceptionType.BLOCK_OVERFLOW), ex);
        }
    }
}
