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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import junit.framework.TestCase;
import org.junit.Test;
import org.xbup.lib.core.block.XBDocument;
import org.xbup.lib.core.parser.data.XBCoreTestSampleData;
import org.xbup.lib.core.test.XBTestUtils;

/**
 * Test class for XBTTreeDocument.
 *
 * @version 0.1.25 2015/08/11
 * @author XBUP Project (http://xbup.org)
 */
public class XBTTreeDocumentWriterTest extends TestCase {

    public XBTTreeDocumentWriterTest(String testName) {
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
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleEmpty() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_EMPTY)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleEmptyTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlock() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockTerminated() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_TERMINATED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockTerminatedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockTerminatedExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_TERMINATED_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockTerminatedExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleData() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleDataTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleDataExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataTerminated() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_TERMINATED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleDataTerminatedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleDataTerminatedExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_DATA_TERMINATED_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleDataTerminatedExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockData() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockDataExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockDataTerminated() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_TERMINATED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataTerminatedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockDataTerminatedExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_TERMINATED_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataTerminatedExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockDataHybrid() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_HYBRID)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataHybridTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleBlockDataHybrid2() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_BLOCK_DATA_HYBRID2)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleBlockDataHybrid2Tree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocks() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksTerminated() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_TERMINATED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksTerminatedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksTerminatedExtended() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_TERMINATED_EXTENDED)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksTerminatedExtendedTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksHybrid() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_HYBRID)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksHybridTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleTwoBlocksHybrid2() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_TWO_BLOCKS_HYBRID2)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleTwoBlocksHybrid2Tree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }

    /**
     * Tests XBTTreeDocument class writing sample data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteSampleSixBlocks() throws Exception {
        try (InputStream stream = XBTTreeDocumentWriterTest.class.getResourceAsStream(XBCoreTestSampleData.SAMPLE_SIX_BLOCKS)) {
            ByteArrayOutputStream target = new ByteArrayOutputStream();
            XBTTreeDocument document = new XBTTreeDocument();
            XBDocument sampleDocument = XBCoreTestSampleData.getSampleSixBlocksTree();
            document.setRootBlock(XBTTreeNode.createTreeCopy(new XBBlockToXBTBlock(sampleDocument.getRootBlock())));
            if (sampleDocument.getExtendedAreaSize() > 0) {
                document.setExtendedArea(sampleDocument.getExtendedArea());
            }

            document.toStreamUB(target);
            XBTestUtils.assertEqualsInputStream(stream, new ByteArrayInputStream(target.toByteArray()));
        }
    }
}
