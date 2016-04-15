cmake_minimum_required (VERSION 2.8)

project(Orthanc_Import)

find_package(Java REQUIRED)
include(UseJava)

set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.6" "-target" "1.6")
set(CMAKE_JAVA_INCLUDE_PATH /usr/share/java/ij.jar)

# The name of an ImageJ plugin must contain an underscore
# http://imagejdocu.tudor.lu/doku.php?id=howto:plugins:howto_create_an_imagej_plugin_jar_file
add_jar(Orthanc_Import
  # Sources of the plugin
  ${CMAKE_SOURCE_DIR}/com/orthancserver/DicomDecoder.java
  ${CMAKE_SOURCE_DIR}/com/orthancserver/Orthanc.java
  ${CMAKE_SOURCE_DIR}/com/orthancserver/OrthancConfigurationDialog.java
  ${CMAKE_SOURCE_DIR}/com/orthancserver/OrthancConnection.java
  ${CMAKE_SOURCE_DIR}/com/orthancserver/PreviewPanel.java
  ${CMAKE_SOURCE_DIR}/com/orthancserver/SelectImageDialog.java

  # Sources of the "json-simple" (1.1.1) toolkit
  ${CMAKE_SOURCE_DIR}/org/json/simple/ItemList.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/JSONArray.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/JSONAware.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/JSONObject.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/JSONStreamAware.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/JSONValue.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/ContainerFactory.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/ContentHandler.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/JSONParser.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/ParseException.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/Yylex.java
  ${CMAKE_SOURCE_DIR}/org/json/simple/parser/Yytoken.java

  # Sources of the "pngj" (2.1.1) toolkit
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ImageInfo.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IChunkFactory.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/Deinterlacer.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ImageLineHelper.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IImageLineArray.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngHelperInternal.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/DeflatedChunksSet.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IImageLine.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/FilterType.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/RowInfo.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngReader.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngReaderByte.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngWriterHc.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IImageLineFactory.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjExceptionInternal.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/DeflatedChunkReader.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IDatChunkWriter.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjBadCrcException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ChunkSeqBuffering.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjUnsupportedException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngReaderFilter.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ImageLineByte.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IBytesConsumer.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ChunkSeqSkipping.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjOutputException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjInputException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IImageLineSetFactory.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ImageLineInt.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngjException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IImageLineSet.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ChunkSeqReaderPng.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IdatSet.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/IPngWriterFactory.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/BufferedStreamFeeder.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkTextVar.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkSPLT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkSBIT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkGAMA.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkCHRM.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkZTXT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkPLTE.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkCopyBehaviour.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkHelper.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkTRNS.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkPHYS.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkITXT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkTIME.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngMetadata.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkACTL.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunk.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkTEXT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkPredicate.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkSingle.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkLoadBehaviour.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkIEND.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkOFFS.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkSRGB.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkFCTL.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkRaw.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunksListForWrite.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkBKGD.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkICCP.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunkFactory.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkUNKNOWN.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkSTER.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/ChunksList.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkIHDR.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkMultiple.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkFDAT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngBadCharsetException.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkHIST.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/chunks/PngChunkIDAT.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngReaderInt.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ImageLineSetDefault.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ChunkReader.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/CompressorStreamDeflater.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/CompressorStream.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/FiltersPerformance.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/PixelsWriterMultiple.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/PixelsWriter.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/DeflaterEstimatorHjg.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/CompressorStreamLz4.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/DeflaterEstimatorLz4.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/pixels/PixelsWriterDefault.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngWriter.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngHelperInternal2.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/PngReaderApng.java
  ${CMAKE_SOURCE_DIR}/com/hjg/pngj/ChunkSeqReader.java
  )

# Add the "plugins.config" file that is expected by ImageJ in the JAR file
add_custom_command(TARGET Orthanc_Import
  POST_BUILD
  COMMAND jar uf ${CMAKE_CURRENT_BINARY_DIR}/Orthanc_Import.jar plugins.config
  WORKING_DIRECTORY ${CMAKE_SOURCE_DIR}
  COMMENT "Packaging the configuration file" VERBATIM
  )
