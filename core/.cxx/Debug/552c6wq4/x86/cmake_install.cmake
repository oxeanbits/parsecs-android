# Install script for directory: /home/krysthian/Workspace/parsecs-android/core

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/usr/local")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "Debug")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

# Install shared libraries without execute permission?
if(NOT DEFINED CMAKE_INSTALL_SO_NO_EXE)
  set(CMAKE_INSTALL_SO_NO_EXE "1")
endif()

# Is this installation the result of a crosscompile?
if(NOT DEFINED CMAKE_CROSSCOMPILING)
  set(CMAKE_CROSSCOMPILING "TRUE")
endif()

# Set default install directory permissions.
if(NOT DEFINED CMAKE_OBJDUMP)
  set(CMAKE_OBJDUMP "/home/krysthian/Android/Sdk/ndk/23.1.7779620/toolchains/llvm/prebuilt/linux-x86_64/bin/llvm-objdump")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib" TYPE STATIC_LIBRARY FILES "/home/krysthian/Workspace/parsecs-android/core/.cxx/Debug/552c6wq4/x86/libmuparserx.a")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib/pkgconfig" TYPE FILE FILES "/home/krysthian/Workspace/parsecs-android/core/.cxx/Debug/552c6wq4/x86/muparserx.pc")
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/share/cmake/muparserx" TYPE FILE FILES
    "/home/krysthian/Workspace/parsecs-android/core/cmake/muparserxConfig.cmake"
    "/home/krysthian/Workspace/parsecs-android/core/.cxx/Debug/552c6wq4/x86/muparserxConfigVersion.cmake"
    )
endif()

if("x${CMAKE_INSTALL_COMPONENT}x" STREQUAL "xUnspecifiedx" OR NOT CMAKE_INSTALL_COMPONENT)
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include/muparserx" TYPE FILE FILES
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpCompat.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpDefines.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpError.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFuncCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFuncCommon.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFuncMatrix.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFuncNonCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFuncStr.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpFwdDecl.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpICallback.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIOprt.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIPackage.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIPrecedence.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIToken.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIValReader.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIValue.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpIfThenElse.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpMatrix.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpMatrixError.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtBinAssign.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtBinCommon.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtIndex.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtMatrix.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtNonCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpOprtPostfixCommon.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageCommon.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageMatrix.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageNonCmplx.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageStr.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpPackageUnit.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpParser.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpParserBase.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpParserMessageProvider.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpRPN.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpScriptTokens.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpStack.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpTest.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpTokenReader.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpTypes.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpValReader.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpValue.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpValueCache.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/mpVariable.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/suSortPred.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/suStringTokens.h"
    "/home/krysthian/Workspace/parsecs-android/core/src/main/cpp/parser/utGeneric.h"
    )
endif()

if(CMAKE_INSTALL_COMPONENT)
  set(CMAKE_INSTALL_MANIFEST "install_manifest_${CMAKE_INSTALL_COMPONENT}.txt")
else()
  set(CMAKE_INSTALL_MANIFEST "install_manifest.txt")
endif()

string(REPLACE ";" "\n" CMAKE_INSTALL_MANIFEST_CONTENT
       "${CMAKE_INSTALL_MANIFEST_FILES}")
file(WRITE "/home/krysthian/Workspace/parsecs-android/core/.cxx/Debug/552c6wq4/x86/${CMAKE_INSTALL_MANIFEST}"
     "${CMAKE_INSTALL_MANIFEST_CONTENT}")
