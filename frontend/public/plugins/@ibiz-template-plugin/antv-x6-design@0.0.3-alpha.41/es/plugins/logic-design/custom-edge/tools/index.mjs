import { resource } from '../../../../global.mjs';

"use strict";
const boundary = () => {
  return {
    name: "boundary",
    args: {
      useCellGeometry: false,
      padding: 5,
      attrs: {
        fill: "#7c68fc",
        stroke: "#333",
        strokeWidth: 0.5,
        fillOpacity: 0.2
      }
    }
  };
};
const sourceArrowhead = () => {
  return {
    name: "source-arrowhead",
    args: {
      attrs: {
        d: "M 12,0 a5,5 0 1,0 10,0 a5,5 0 1,0 -10,0",
        fill: "#feb663"
      }
    }
  };
};
const targetArrowhead = () => {
  return {
    name: "target-arrowhead",
    args: {
      attrs: {
        d: "M -20,0 a5,5 0 1,0 10,0 a5,5 0 1,0 -10,0",
        fill: "#feb663"
      }
    }
  };
};
const vertices = () => {
  return {
    name: "vertices",
    args: {
      attrs: { fill: "#666" }
    }
  };
};
const shiftButton = (status, className, onClick) => {
  let markup = [
    {
      tagName: "circle",
      selector: "button",
      attrs: {
        r: 7,
        stroke: "#FB8C02",
        fill: "#FFFFFF",
        class: className.svg_shift_wrapper,
        cursor: "pointer"
      }
    },
    {
      tagName: "path",
      selector: "icon",
      attrs: {
        d: "M13.7234375,6.1265625 L9.8734375,2.2765625 C9.771875,2.175 9.6390625,2.125 9.50625,2.125 C9.3734375,2.125 9.240625,2.175 9.1390625,2.2765625 L6.621875,4.7953125 C6.43125,4.7734375 6.2390625,4.7640625 6.046875,4.7640625 C4.903125,4.7640625 3.759375,5.140625 2.8203125,5.89375 C2.5796875,6.0859375 2.559375,6.446875 2.778125,6.665625 L5.6171875,9.5046875 L2.2515625,12.8671875 C2.2109375,12.9078125 2.184375,12.9625 2.1796875,13.0203125 L2.1265625,13.6015625 C2.1125,13.7484375 2.2296875,13.8734375 2.375,13.8734375 C2.3828125,13.8734375 2.390625,13.8734375 2.3984375,13.871875 L2.9796875,13.81875 C3.0375,13.8140625 3.0921875,13.7875 3.1328125,13.746875 L6.4984375,10.38125 L9.3375,13.2203125 C9.4390625,13.321875 9.571875,13.371875 9.7046875,13.371875 C9.85625,13.371875 10.00625,13.30625 10.109375,13.178125 C10.9890625,12.0796875 11.3546875,10.7046875 11.20625,9.375 L13.7234375,6.8578125 C13.925,6.6578125 13.925,6.3296875 13.7234375,6.1265625 Z M10.409375,8.5828125 L10.0265625,8.965625 L10.0859375,9.503125 C10.14375,10.0296875 10.1015625,10.553125 9.9578125,11.0609375 C9.8734375,11.3578125 9.7578125,11.640625 9.6109375,11.9078125 L4.09375,6.3875 C4.2953125,6.2765625 4.5046875,6.1828125 4.7234375,6.1078125 C5.1484375,5.9609375 5.59375,5.8875 6.046875,5.8875 C6.196875,5.8875 6.3484375,5.8953125 6.4984375,5.9125 L7.0359375,5.971875 L7.41875,5.5890625 L9.5078125,3.5 L12.5,6.4921875 L10.409375,8.5828125 Z",
        fill: "#FB8C02",
        class: className.svg_shift1,
        stroke: "none",
        "stroke-width": 2,
        "pointer-events": "none"
      }
    }
  ];
  if (status) {
    markup = [
      {
        tagName: "circle",
        selector: "button",
        attrs: {
          r: 7,
          stroke: "#FB8C02",
          fill: "#FFFFFF",
          class: className.svg_shift_wrapper,
          cursor: "pointer"
        }
      },
      {
        tagName: "path",
        selector: "icon",
        attrs: {
          d: "M3.43085937,9.53105469 C3.47324219,9.5734375 3.54160156,9.5734375 3.58535156,9.53105469 L5.47617187,7.64980469 L7.22070312,9.40527344 C7.26308594,9.44765625 7.3328125,9.44765625 7.37519531,9.40527344 L11.1404297,5.64140625 C11.1828125,5.59902344 11.1828125,5.52929688 11.1404297,5.48691406 L10.5990234,4.94550781 C10.5566406,4.903125 10.4869141,4.903125 10.4445312,4.94550781 L7.3,8.08867188 L5.55820312,6.3359375 C5.51582031,6.29355469 5.44609375,6.29355469 5.40371094,6.3359375 L2.89082031,8.83378906 C2.8484375,8.87617188 2.8484375,8.94589844 2.89082031,8.98828125 L3.43085937,9.53105469 Z",
          fill: "#FB8C02",
          class: className.svg_shift1,
          stroke: "none",
          "stroke-width": 2,
          "pointer-events": "none"
        }
      }
    ];
  }
  return {
    name: "logic-link-shift-button",
    args: {
      markup,
      distance: 0,
      zIndex: 999,
      onClick
    }
  };
};
const loopIcon = () => {
  return {
    name: "logic-link-loop-icon",
    args: {
      markup: {
        tagName: "image",
        attrs: {
          width: 28,
          height: 28,
          "xlink:href": resource.dir("./assets/svg/loop-call.svg")
        }
      },
      distance: 20,
      offset: { x: 0, y: 20 },
      zIndex: 999
    }
  };
};

export { boundary, loopIcon, shiftButton, sourceArrowhead, targetArrowhead, vertices };
