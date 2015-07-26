/*
 * Copyright (C) XBUP Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.xbup.lib.parser_tree;

import junit.framework.TestCase;
import org.junit.Test;
import org.xbup.lib.core.parser.basic.convert.XBConsumerToListener;
import org.xbup.lib.core.parser.basic.convert.XBPrintFilter;
import org.xbup.lib.core.parser.data.XBCoreTestSampleData;
import org.xbup.lib.core.test.XBTestUtils.BufferAssertXBFilter;

/**
 * Test class for XBTreeWriter.
 *
 * @version 0.1.25 2015/07/26
 * @author XBUP Project (http://xbup.org)
 */
public class XBTreeWriterTest extends TestCase {

    public XBTreeWriterTest(String testName) {
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
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleEmpty() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleEmpty(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleEmptyTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlock() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleBlock(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleBlockTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockExtended() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleBlockExtended(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleBlockExtendedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockTerminated() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleBlockTerminated(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleBlockTerminatedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockTerminatedExtended() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleBlockTerminatedExtended(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleBlockTerminatedExtendedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleData() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleData(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleDataTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataExtended() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleDataExtended(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleDataExtendedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataTerminated() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleDataTerminated(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleDataTerminatedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataTerminatedExtended() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleDataTerminatedExtended(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleDataTerminatedExtendedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocks() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleTwoBlocks(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleTwoBlocksTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksExtended() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleTwoBlocksExtended(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleTwoBlocksExtendedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksTerminated() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleTwoBlocksTerminated(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleTwoBlocksTerminatedTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksHybrid() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleTwoBlocksHybrid(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleTwoBlocksHybridTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksHybrid2() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleTwoBlocksHybrid2(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleTwoBlocksHybrid2Tree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }

    /**
     * Tests XBTreeWriter class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleSixBlocks() throws Exception {
        XBConsumerToListener buffer = new XBConsumerToListener(null);
        XBCoreTestSampleData.writeSampleSixBlocks(buffer);
        BufferAssertXBFilter assertListener = new BufferAssertXBFilter(buffer.getTokens());

        XBTreeWriter treeWriter = new XBTreeWriter(XBCoreTestSampleData.getSampleSixBlocksTree());
        treeWriter.attachXBListener(new XBPrintFilter(assertListener));
    }
}
