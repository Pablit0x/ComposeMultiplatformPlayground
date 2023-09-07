//
//  ComposeView.swift
//  iosApp
//
//  Created by Paweł Szymański on 07/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct ComposeView : UIViewControllerRepresentable {
    
    func makeUIViewController(context: Context) -> some UIViewController {
        AppScreenKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
}
